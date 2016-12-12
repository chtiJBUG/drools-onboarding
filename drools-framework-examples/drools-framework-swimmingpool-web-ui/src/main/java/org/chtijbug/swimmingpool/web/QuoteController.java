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
package org.chtijbug.swimmingpool.web;


import org.chtijbug.drools.generic.restclient.rest.UsedRestAPI;
import org.chtijbug.example.swimmingpool.Quote;
import org.springframework.web.bind.annotation.*;

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
    private UsedRestAPI serviceCalculate;



    @RequestMapping(value = "/calculate/{containerId}", method = RequestMethod.PUT)
    public Quote storeTicket(@PathVariable("containerId") String containerid,
                             @RequestBody Quote quoteRequest) {
        Quote response = null;
        try {
            response = (Quote) serviceCalculate.runSession(containerid,"swimmingpool.P000",Quote.class.getCanonicalName(),quoteRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }
}
