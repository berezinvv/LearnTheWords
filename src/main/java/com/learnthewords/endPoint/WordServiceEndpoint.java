package com.learnthewords.endPoint;


import com.learnthewords.entity.Word;
import com.learnthewords.service.WordService;
import generated.GetWordByIdRequest;
import generated.GetWordByIdResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WordServiceEndpoint {

    private static final String NAMESPACE_URI = "http://localhost:8080/ws";

    @Autowired
    private WordService wordService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWordByIdRequest")
    @ResponsePayload
    public GetWordByIdResponse getArticle(@RequestPayload GetWordByIdRequest request) {
        GetWordByIdResponse response = new GetWordByIdResponse();
        Word word = wordService.findWordById(request.getId());
        response.setId(word.getId());
        response.setName(word.getName());
        response.setPopularity(word.getPopularity());

        return response;
    }

}
