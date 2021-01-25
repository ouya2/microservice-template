package au.com.acne.myapi.domain;

import au.com.acne.myapi.Code;

/**
 * A simple example model, which Jackson should be able to serialize out-of-the-box.
 */
public final class DomainResponse {

    private String content;

    private Code code;

    private DomainResponse() {

    }

    public static DomainResponse of(final String content, final Code code) {
        DomainResponse dr = new DomainResponse();
        dr.content = content;
        dr.code = code;
        return dr;
    }

    public String getContent() {
        return content;
    }

    public Code getCode() {
        return code;
    }

}
