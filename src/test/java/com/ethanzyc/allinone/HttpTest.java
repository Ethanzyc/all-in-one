package com.ethanzyc.allinone;

import okhttp3.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ethan
 * @date 2019/7/12 15:07
 */
public class HttpTest {

    @Test
    public void test() throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\n\t\"updateTime\": \"2019-07-11\",\n\t\"page\": 1,\n\t\"rows\": 1000\n}");
        Request request = new Request.Builder()
                .url("http://cust-console.kujiatech.com/api/baseService/employeeInfo/seleEmployeeByDay")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Mayi-Token", "eyJhbGciOiJIUzI1NiJ9.eyJyZWFsX25hbWUiOiLlsI_lt6XomoHlvIDlj5HnlKgiLCJVU0VSX05BTUUiOiIxNTEwMDAwMDEwMCIsIkxPR0lOX0dST1VQX0lEIjoxLCJ0dGwiOjM2MDAwMDAwMDAwMCwianRpIjoiZDUxNzMyY2E0MDUwNDk5ZTliYzQ4NDk4ODczZTQxNzAiLCJpYXQiOjE1NTg2ODY5NDcsInN1YiI6IjM0MDA3IiwiaXNzIjoiRU1QTE9ZRUUiLCJleHAiOjE5MTg2ODY5NDd9.nqjUnbN8KzCQD95RB0UudzkKdO6EbdWzxgZPRHZnqkU")
                .build();

        Response response = client.newCall(request).execute();

        String string = response.body().string();
        System.out.println(string);
    }
}
