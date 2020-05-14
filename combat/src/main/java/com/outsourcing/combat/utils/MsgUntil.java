package com.outsourcing.combat.utils;

public class MsgUntil extends BaseController {

    public static final String MSG_Enter_Air = "输入为空";

    public static final String MSG_Output_AIR = "输出为空";

    public static final String MSG_Abnormal = "异常";

    public static final String MSG_Inquire_Success = "查询成功";

    public static final String MSG_Modify_Success = "修改成功";

    public static final String MSG_Increase_Success = "添加成功";

    public static final String MSG_Delete_Success = "删除成功";

    public static final String MSG_Restore_Success = "恢复成功";

    public static final String MSG_Failure = "失败";

    //判断String是否为空
    public boolean Judge(String a) {
        if (a == null || a == "") {
            return true;
        }
        return false;
    }

    //判断Integer是否为空
    public boolean Judge(Integer a) {
        if (a == null) {
            return true;
        }
        return false;
    }
}
