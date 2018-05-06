package com.teambition.tool.api;


import com.teambition.tool.util.OkHttp3Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yingchun on 2017/10/27.
 */
public class Message {
    private String apiKey = null;
    private String url = null;

    public Message (String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    /**
     * @param _organizationId 接收者所在的企业ID
     * @param objects         接收消息的对象 最多10个
     * @param content         消息类型, 目前仅支持 text
     * @param toType          接收方类型, 可选: projects / users / groups ， objects 中则填对应的id
     * @return
     * @throws IOException
     */
    public String send (String _organizationId, String[] objects, String content, String toType) throws IOException {
        Map<String, String> header = new HashMap<>();
        header.put("x-api-key", apiKey);

        Map<String, String> params = new HashMap<>();
        params.put("_organizationId", _organizationId);
        int i = 0;

        switch (toType) {
            case "groups":
                for (String group : objects) {
                    params.put(String.format("groups[%s]", i), group);
                    i++;
                }
                break;
            case "projects":
                for (String project : objects) {
                    params.put(String.format("projects[%s]", i), project);
                    i++;
                }
                break;
            case "users":
                for (String user : objects) {
                    params.put(String.format("users[%s]", i), user);
                    i++;
                }
                break;
        }


        params.put("messageType", "text");
        params.put("text", content);
        params.put("toType", toType);
        return OkHttp3Utils.doPost(url, params, header);
    }

}
