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
package org.chtijbug.loyaltywebstandard;


import org.chtijbug.drools.runtime.RuleBaseSession;
import org.chtijbug.drools.runtime.impl.RuleBaseCommandSession;
import org.chtijbug.drools.runtime.impl.RuleBaseCommandSingleton;
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
    private RuleBaseCommandSingleton ruleBaseCommandSingleton;



    @RequestMapping(value = "/calculate/{containerId}", method = RequestMethod.PUT)
    public Quote storeTicket(@PathVariable("containerId") String containerid,
                             @RequestBody Quote quoteRequest) {
        Quote response = null;
        try {
            RuleBaseCommandSession session = (RuleBaseCommandSession) ruleBaseCommandSingleton.createRuleBaseSession();
            response = (Quote) session.fireAllRulesAndStartProcess(quoteRequest,"swimmingpool.P000");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;

    }
}
