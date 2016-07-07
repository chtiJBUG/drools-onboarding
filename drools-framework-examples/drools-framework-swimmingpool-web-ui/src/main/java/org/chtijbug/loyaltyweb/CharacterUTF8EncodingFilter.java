package org.chtijbug.loyaltyweb;

import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by IntelliJ IDEA.
 * Date: 20/10/14
 * Time: 09:27
 * To change this template use File | Settings | File Templates.
 */
@WebFilter(urlPatterns = {"/*"}, filterName = "CharacterEncodingFilter", initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8"),
        @WebInitParam(name = "forceEncoding", value = "true"),
})
public class CharacterUTF8EncodingFilter extends CharacterEncodingFilter {


}
