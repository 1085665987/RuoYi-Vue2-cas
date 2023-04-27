<template>
  <div>
    <el-input v-model="url" type="text" style="width: 20%" /> &nbsp; &nbsp;
    <el-button @click="join" type="primary">连接</el-button>
    <el-button @click="exit" type="danger">断开</el-button>

    <br />
    <el-input type="textarea" v-model="message" :rows="9" />
    <el-button type="info" @click="send">发送消息</el-button>
    <br />
    <br />
    <el-input type="textarea" v-model="text_content" :rows="9" /> 返回内容
    <br />
    <br />
  </div>
</template>

<script>
export default {
  data() {
    return {
      url: "ws://127.0.0.1:8080/websocket/message",
      message: "",
      text_content: "",
      ws: null,
    };
  },
  methods: {
    join() {
      const wsuri = this.url;
      this.ws = new WebSocket(wsuri);
      const self = this;
      this.ws.onopen = function (event) {
        self.text_content = self.text_content + "已经打开连接!" + "\n";
      };
      this.ws.onmessage = function (event) {
        self.text_content = event.data + "\n";
      };
      this.ws.onclose = function (event) {
        self.text_content = self.text_content + "已经关闭连接!" + "\n";
      };
    },
    exit() {
      if (this.ws) {
        this.ws.close();
        this.ws = null;
      }
    },
    send() {
      if (this.ws) {
        this.ws.binaryType = 'arraybuffer';
        // this.ws.send(this.message);
        this.ws.send(this.stringToByte(this.message));
      } else {
        alert("未连接到服务器");
      }
    },
    //将字符串转为 Array byte数组
    stringToByte(str) {
      let bytes = [
        // 第一个数FE(254)：mavlink数据包的起始位（mavlink1.0是以FE开头）
        0xFE,
        // 第二个数09：表明数据包的有效载荷长度为9个即00 00 00 00 0D 03 51 03 03
        0x09,
        // 第三个数36(54)：发送该心跳包是从开机开始算的第几个数据包，中间可能掺杂了其他的数据包，用于校验是否丢包
        0x36,
        // 第四个数01：sysid（system ID）发送系统的ID
        0x01,
        // 第五个数01：compid（componene ID）发送单元ID
        0x01,
        // 第六个数00：代表本消息的有效载荷的编号，即心跳包的编号是#0
        0x00,
        /********************************** 负载开始 ****************************************/
        // 第七个数（uint32_t即4个16进制数）00 00 00 00：即custom_mode（用户模式），即用于自动驾驶仪的特别的一个标志位的模式设置，
        // APM中包括17模式，在使用APM飞控时，根据自己的目的要在使用前，先给APM发送改变模式的数据包，将APM变化模式，
        // 一般custom_mode和base_mode是一起的。00 00 00 00表示0是STABILIZE（自稳模式）
        0x00,
        0x00,
        0x00,
        0x00,
        // 第八个数0D(13)：即type（类型），0D表示 MAV_TYPE_HEXAROTOR（六轴）
        0x0D,
        // 第九个数03：即autopilot（微型飞行器即飞控板类型），03表示MAV_AUTOPILOT_ARDUPILOTMEGA（ArduPilotMega / ArduCopter即APM飞控）
        0x03,
        // 第十个数51(81)：即base_mode（基本模式）
        0x51,
        // 第十一个数03：即 system_status（系统状态标志）如下图，03表示系统已接地并处于待机状态。任何时间都可以发射。
        0x03,
        // 第十二个数03：即 mavlink_version（mavlink版，不可写的用户，获取补充协议因为神奇的数据类型），默认就是3，这是开发者写好的。
        0x03,
        /********************************** 负载结束 ****************************************/
        // 第十三和十四个数F4(244) 11：这是校验位，调用系统函数后，会加到消息包的最后。
        0xF4,
        0x11
      ]
      // 创建一个(bytes.length)字节长度的缓冲
      var buffer = new ArrayBuffer(bytes.length);
      // 创建一个视图，此视图把缓冲内的数据格式化为一个8位（1字节）有符号整数数组
      var int32View = new Int8Array(buffer);
      // 我们可以像普通数组一样访问该数组中的元素
      for (var i = 0; i < int32View.length; i++) {
        int32View[i] = bytes[i];
      }
      return int32View
    },
  },
};
</script>
