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
package org.chtijbug.loyalty.web;


import loyalty.domains.Ticket;

import org.chtijbug.drools.generic.restclient.rest.UsedRestAPI;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.PathParam;

/**
 * Created by IntelliJ IDEA.
 * Date: 08/10/14
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Resource
    private UsedRestAPI serviceCalculate;


    @RequestMapping(value = "/calculate/{id}", method = RequestMethod.PUT)
    public Ticket storeTicket(@PathParam("id") String id, @RequestBody Ticket ticket) {
        Ticket response = null;
        try {
            response = (Ticket)serviceCalculate.runSession(id,"P1.P1","loyalty.domains.Ticket",ticket);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }
}
