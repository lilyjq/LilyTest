package com.example.lily.lilytest.Retrofit;

import java.util.List;

/**
 * Created by ljq
 * on 2018/2/24.
 */

public class AirResponse {
    String resultCode;
    String reason;
    String error_code;
    List<AirCity> result;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public List<AirCity> getResult() {
        return result;
    }

    public void setResult(List<AirCity> result) {
        this.result = result;
    }
}
