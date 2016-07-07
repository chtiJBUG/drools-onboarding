#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package org.chtijbug.drools.ws;


import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created with IntelliJ IDEA.
 * User: smangot
 * Date: 14/09/12
 * Time: 09:00
 */
@WebService
public interface RulesRunnerService {

    /**
     * @param input
     * @return
     */
    ${decision-outputClass} executeRuleEngine(@WebParam(name="input") ${decision-inputClass} input);

    /**
     * The method starts the specified process with the input element fact argument
     * @param input The input object
     * @param processName The process name to start
     * @return the input object updated through the rule engine execution
     */
    ${decision-outputClass} executeProcess(@WebParam(name="input") ${decision-inputClass} input, @WebParam(name="processName") String processName);
}
