'use strict'

const casServer = process.env.VUE_APP_CAS_SERVER

const backendHostIp = process.env.VUE_APP_BACK_END_HOST_AND_PORT

module.exports = {
    /**
     * 开启cas
     */
    casEnable: false,

    /**
     * 单点登录url
     */
    casloginUrl: casServer + '/cas/login?service=' + backendHostIp,

    /**
     * 单点登出url
     */
    caslogoutUrl: casServer + '/cas/logout?service=' + backendHostIp,

    /**
     * 侧边栏主题 深色主题theme-dark，浅色主题theme-light
     */
    sideTheme: 'theme-dark',

    /**
     * 是否系统布局配置
     */
    showSettings: false,

    /**
     * 是否显示顶部导航
     */
    topNav: false,

    /**
     * 是否显示 tagsView
     */
    tagsView: true,

    /**
     * 是否固定头部
     */
    fixedHeader: false,

    /**
     * 是否显示logo
     */
    sidebarLogo: true,

    /**
     * 是否显示动态标题
     */
    dynamicTitle: false,

    /**
     * @type {string | array} 'production' | ['production', 'development']
     * @description Need show err logs component.
     * The default is only used in the production env
     * If you want to also use it in dev, you can pass ['production', 'development']
     */
    errorLog: 'production'
}
