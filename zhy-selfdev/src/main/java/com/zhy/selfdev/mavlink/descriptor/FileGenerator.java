package com.zhy.selfdev.mavlink.descriptor;

/**********************************
 * Author YSW
 * Description
 * Date 2020.10.29 - 20:42
 **********************************/

public class FileGenerator {

	public static void generator(String srcFile, String targetFolder){
		new EnumDescriptor().descriptor(srcFile, targetFolder+"\\enums");
		new MavCmdEnumDescriptor().descriptor(srcFile, targetFolder+"\\enums\\mav\\cmd");
		new MessageDescriptor().descriptor(srcFile, targetFolder+"\\messages");
	}

	public static void main(String[] args) {
		generator("E:\\workspace\\zhy-vue\\zhy-selfdev\\src\\main\\resources\\zhy.xml","C:\\Users\\wjj\\Desktop\\zhy-mavlink\\");
	}
}
