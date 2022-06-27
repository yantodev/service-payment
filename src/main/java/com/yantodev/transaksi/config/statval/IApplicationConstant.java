package com.yantodev.transaksi.config.statval;

public interface IApplicationConstant {

    interface ContextPath {
        String USER_V1 = "/v1/user";
        String AUTH_V1 = "/v1/auth";
    }

    interface path {

        interface user {
            String ADD_USER = "/add-user";
            String UPDATE_USER = "/update-user";
            String DELETE_USER = "/delete-user";
            String GET_USER = "/get-user";
        }

        interface auth {
            String LOGIN = "/login";
        }
    }
}
