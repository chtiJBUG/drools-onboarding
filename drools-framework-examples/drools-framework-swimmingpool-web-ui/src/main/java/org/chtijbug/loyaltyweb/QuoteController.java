/*
 * Copyright 2014 Pymma Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.chtijbug.loyaltyweb;


import org.chtijbug.drools.swimmingpool.restclient.rest.SwimmingPoolRestAPI;
import org.chtijbug.example.swimmingpool.Quote;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 * Date: 08/10/14
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/quote")
public class QuoteController {
    @Resource
    private SwimmingPoolRestAPI serviceCalculate;

    @Value(value="${url.swimmingpool.calculate.containerId}")
    private String containerid;

    @RequestMapping(value = "/calculate", method = RequestMethod.PUT)
    public Quote storeTicket(@RequestBody Quote quoteRequest) {
        Quote response = null;
        try {
            response = serviceCalculate.runSession(containerid,quoteRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }
}
