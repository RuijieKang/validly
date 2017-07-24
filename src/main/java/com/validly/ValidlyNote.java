package com.validly;

import java.util.List;
import java.util.Map;

public interface ValidlyNote {

    void addMessage(String fieldName, String message);

    Map<String, List<String>> getMessages();

}