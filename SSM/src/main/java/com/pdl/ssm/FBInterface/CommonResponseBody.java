package com.pdl.ssm.FBInterface;

import org.springframework.stereotype.Component;

/**
 * Date: 2023/1/30 22:27
 *
 * @author 潘栋磊
 * @version 0.0.1
 */
public class CommonResponseBody {
    private int status;

    private String statusNote;

    private String msg;

    private Object data;


    {
        status = 200;
        statusNote = "ok";
        msg="success";
    }

    public CommonResponseBody() {
    }

    public CommonResponseBody(int status, String statusNote, String msg, Object data) {
        this.status = status;
        this.statusNote = statusNote;
        this.msg = msg;
        this.data = data;
    }

    public CommonResponseBody(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonResponseBody that)) return false;

        if (getStatus() != that.getStatus()) return false;
        if (!getMsg().equals(that.getMsg())) return false;
        return getData() != null ? getData().equals(that.getData()) : that.getData() == null;
    }

    @Override
    public int hashCode() {
        int result = getStatus();
        result = 31 * result + getMsg().hashCode();
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }

    public int getStatus() {
        return status;
    }

    public CommonResponseBody setStatus(int status) {
        this.status = status;
        if(this.msg==null || "".equals(this.msg)) {
            switch (status){
                case 200:
                    setMsg("");
                    setStatusNote("ok");
                    break;
                case 404:
                    setMsg("Not Found!");
                    setStatusNote("error");
                    break;
                default:
                    setMsg(null);
            }
        }

        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CommonResponseBody setMsg(String msg) {

        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public CommonResponseBody setData(Object data) {
        this.data = data;
        return this;
    }
    public CommonResponseBody setStatusNote(String statusNote) {
        this.statusNote = statusNote;
        return this;
    }

    public String getStatusNote() {
        return statusNote;
    }

}
