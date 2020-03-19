/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AJAX;

import java.util.ArrayList;

/**
 *
 * @author Yash
 */
public class UserIdList {

    private ArrayList<String> userIdList = new ArrayList<>();

    public ArrayList<String> getList() {
        return userIdList;
    }

    public UserIdList() {
        userIdList.add("a@xyz.com");
        userIdList.add("b@xyz.com");
        userIdList.add("c@xyz.com");
        userIdList.add("abc@xyz.com");
        userIdList.add("xyz@xyz.com");
        userIdList.add("def@xyz.com");
    }

    public void addId(String userId) {
        userIdList.add(userId);
    }

    public boolean isPresent(String userId) {
        boolean status = false;
        for (String id : userIdList) {
            if (id.compareTo(userId) == 0) {
                status = true;
                break;
            }
        }
        return status;
    }
}
