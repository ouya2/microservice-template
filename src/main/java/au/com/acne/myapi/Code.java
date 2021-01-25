package au.com.acne.myapi;

/**
 * <p>
 *     A list of codes presented by the API to the consuming application. The codes are documented by the API documentation,
 *     so the documentation is not returned with the codes. This means that the client is free to apply whatever text it
 *     pleases to the error code.
 * </p>
 * <p>
 *     The developer should try to create as many codes as would be useful in supporting the deployed application, you
 *     want as many as possible, you want them specific, and you want them descriptive.
 * </p>
 * <p>
 *     The hope is that eventually, these codes could be shown on the Website error pages, so that when the inevitable
 *     screenshot from support arrives in your inbox, it will actually (and unintentionally) be useful for once.
 * </p>
 */
public enum Code {
    /**
     * Everything was OK.
     */
    OK(0),

    /**
     * A header required for business processing was missing
     */
    MISSING_REQUEST_HEADER(10),

    /**
     * A parameter required for business processing was missing
     */
    MISSING_REQUEST_PARAMETER(20),

    /**
     * A parameter required for business processing was invalid
     */
    INVALID_INPUT_FOR_ACTION(30),

    /**
     * A combination of headers and parameters means that the user is in an inconsistent state
     */
    INCONSISTENT_USER_STATE(40);


    private final int code;

    Code(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }

}
