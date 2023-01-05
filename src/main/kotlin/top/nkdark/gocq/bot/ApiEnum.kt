package top.nkdark.gocq.bot

enum class ApiEnum(val endpoint: String, val description: String) {
    SEND_PRIVATE_MSG("send_private_msg", "发送私聊消息"),
    SEND_GROUP_MSG("send_group_msg", "发送群消息"),
    SEND_GROUP_FORWARD_MSG("send_group_forward_msg", "发送合并转发 ( 群 )"),
    SEND_MSG("send_msg", "发送消息"),
    DELETE_MSG("delete_msg", "撤回消息"),
    GET_MSG("get_msg", "获取消息"),
    GET_FORWARD_MSG("get_forward_msg", "获取合并转发内容"),
    GET_IMAGE("get_image", "获取图片"),
    MARK_MSG_AS_READ("mark_msg_as_read", "标记消息已读"),
    SET_GROUP_KICK("set_group_kick", "群组踢人"),
    SET_GROUP_BAN("set_group_ban", "群组单人禁言"),
    SET_GROUP_ANONYMOUS_BAN("set_group_anonymous_ban", "群组匿名用户禁言"),
    SET_GROUP_WHOLE_BAN("set_group_whole_ban", "群组全员禁言"),
    SET_GROUP_ADMIN("set_group_admin", "群组设置管理员"),

    // not implement
    // SET_GROUP_ANONYMOUS("set_group_anonymous", "群组匿名"),

    SET_GROUP_CARD("set_group_card", "设置群名片（群备注）"),
    SET_GROUP_NAME("set_group_name", "设置群名"),
    SET_GROUP_LEAVE("set_group_leave", "退出群组"),
    SET_GROUP_SPECIAL_TITLE("set_group_special_title", "设置群组专属头衔"),
    SEND_GROUP_SIGN("send_group_sign", "群打卡"),
    SET_FRIEND_ADD_REQUEST("set_friend_add_request", "处理加好友请求"),
    SET_GROUP_ADD_REQUEST("set_group_add_request", "处理加群请求／邀请"),
    GET_LOGIN_INFO("get_login_info", "获取登录号信息"),

    /**
     * 此API只有企点协议可用
     */
    QIDIAN_GET_ACCOUNT_INFO("qidian_get_account_info", "获取企点账号信息"),
    SET_QQ_PROFILE("set_qq_profile", "设置登录号资料"),
    GET_STRANGER_INFO("get_stranger_info", "获取陌生人信息"),
    GET_FRIEND_LIST("get_friend_list", "获取好友列表"),
    GET_UNIDIRECTIONAL_FRIEND_LIST("get_unidirectional_friend_list", "获取单向好友列表"),
    DELETE_FRIEND("delete_friend", "删除好友"),
    GET_GROUP_INFO("get_group_info", "获取群信息"),
    GET_GROUP_LIST("get_group_list", "获取群列表"),
    GET_GROUP_MEMBER_INFO("get_group_member_info", "获取群成员信息"),
    GET_GROUP_MEMBER_LIST("get_group_member_list", "获取群成员列表"),
    GET_GROUP_HONOR_INFO("get_group_honor_info", "获取群荣誉信息"),

    // not implement
    // GET_COOKIES("get_cookies", "获取 Cookies"),
    // GET_CSRF_TOKEN("get_csrf_token", "获取 CSRF Token"),
    // 上面两个接口的合并
    // GET_CREDENTIALS("get_credentials", "获取 QQ 相关接口凭证"),
    // GET_RECORD("get_record", "获取语音"),
    CAN_SEND_IMAGE("can_send_image", "检查是否可以发送图片"),
    CAN_SEND_RECORD("can_send_record", "检查是否可以发送语音"),
    GET_VERSION_INFO("get_version_info", "获取版本信息"),

    /**
     * 由于重启 go-cqhttp 实现同时需要重启 API 服务, 这意味着当前的 API 请求会被中断, 因此需要异步地重启, 接口返回的 status 是 async。
     *
     * 不会获得响应
     */
    SET_RESTART("set_restart", "重启 go-cqhttp"),

    // not implement
    // CLEAN_CACHE("clean_cache", "清理缓存"),

    SET_GROUP_PORTRAIT("set_group_portrait", "设置群头像"),

    /**
     * 目前图片OCR接口仅支持接受的图片
     */
    OCR_IMAGE("ocr_image", "图片 OCR"),
    GET_GROUP_SYSTEM_MSG("get_group_system_msg", "获取群系统消息"),

    /**
     * 只能上传本地文件, 需要上传 http 文件的话请先调用 [download_file][DOWNLOAD_FILE] API下载
     */
    UPLOAD_PRIVATE_FILE("upload_private_file", "上传私聊文件"),

    /**
     * 在不提供 folder 参数的情况下默认上传到根目录
     *
     * 只能上传本地文件, 需要上传 http 文件的话请先调用 [download_file][DOWNLOAD_FILE] API下载
     */
    UPLOAD_GROUP_FILE("upload_group_file", "上传群文件"),
    GET_GROUP_FILE_SYSTEM_INFO("get_group_file_system_info", "获取群文件系统信息"),
    GET_GROUP_ROOT_FILES("get_group_root_files", "获取群根目录文件列表"),
    GET_GROUP_FILES_BY_FOLDER("get_group_files_by_folder", "获取群子目录文件列表"),

    /**
     * 仅能在根目录创建文件夹
     */
    CREATE_GROUP_FILE_FOLDER("create_group_file_folder", "创建群文件文件夹"),

    /**
     * 该 API 没有响应数据
     */
    DELETE_GROUP_FOLDER("delete_group_folder", "删除群文件文件夹"),

    /**
     * 该 API 没有响应数据
     */
    DELETE_GROUP_FILE("delete_group_file", "删除群文件"),
    GET_GROUP_FILE_URL("get_group_file_url", "获取群文件资源链接"),

    /**
     * 所有统计信息都将在重启后重置
     */
    GET_STATUS("get_status", "获取状态"),
    GET_GROUP_AT_ALL_REMAIN("get_group_at_all_remain", "获取群 @全体成员 剩余次数"),

    /**
     * 该 API 没有响应数据
     */
    SEND_GROUP_NOTICE("_send_group_notice", "发送群公告"),
    GET_GROUP_NOTICE("_get_group_notice", "获取群公告"),

    /**
     * 该 API 没有响应数据
     */
    RELOAD_EVENT_FILTER("reload_event_filter", "重载事件过滤器"),

    /**
     * 通过这个API下载的文件能直接放入CQ码作为图片或语音发送
     *
     * 调用后会阻塞直到下载完成后才会返回数据，请注意下载大文件时的超时
     */
    DOWNLOAD_FILE("download_file", "下载文件到缓存目录"),
    GET_ONLINE_CLIENTS("get_online_clients", "获取当前账号在线客户端列表"),
    GET_GROUP_MSG_HISTORY("get_group_msg_history", "获取群消息历史记录"),

    /**
     * 该 API 没有响应数据
     */
    SET_ESSENCE_MSG("set_essence_msg", "设置精华消息"),

    /**
     * 该 API 没有响应数据
     */
    DELETE_ESSENCE_MSG("delete_essence_msg", "移出精华消息"),
    GET_ESSENCE_MSG_LIST("get_essence_msg_list", "获取精华消息列表"),
    CHECK_URL_SAFELY("check_url_safely", "检查链接安全性"),
    GET_MODEL_SHOW("_get_model_show", "获取在线机型"),

    /**
     * 该 API 没有响应数据
     *
     * [可能不好使了](https://github.com/Mrs4s/go-cqhttp/pull/872#issuecomment-1249986232)，未测试
     */
    SET_MODEL_SHOW("_set_model_show", "设置在线机型"),

    /**
     * 该 API 没有响应数据
     */
    DELETE_UNIDIRECTIONAL_FRIEND("delete_unidirectional_friend", "删除单向好友"),
    SEND_PRIVATE_FORWARD_MSG("send_private_forward_msg", "发送合并转发 ( 好友 )"),
}