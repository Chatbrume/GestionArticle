package fr.ensup.gestionarticle.controller;

public enum CodeHttp
{
    CONTINUE (100, "The server has received the request headers and the client should proceed to send the request body. Sending a large request body to a server after a request has been rejected for inappropriate headers would be inefficient. To have a server check the request's headers, a client must send Expect: 100-continue as a header in its initial request and receive a 100 Continue status code in response before sending the body. If the client receives an error code such as 403 (Forbidden) or 405 (Method Not Allowed) then it should not send the request's body. The response 417 Expectation Failed indicates that the request should be repeated without the Expect header as it indicates that the server does not support expectations"),
    SWITCHING_PROTOCOLS (101, "The requester has asked the server to switch protocols and the server has agreed to do so."),
    PROCESSING (102, "A WebDAV request may contain many sub-requests involving file operations, requiring a long time to complete the request. This code indicates that the server has received and is processing the request, but no response is available yet. This prevents the client from timing out and assuming the request was lost."),
    EARLY_HINTS (103, "Used to return some response headers before final HTTP message."),
    OK (200, "Standard response for successful HTTP requests. The actual response will depend on the request method used. In a GET request, the response will contain an entity corresponding to the requested resource. In a POST request, the response will contain an entity describing or containing the result of the action."),
    CREATED (201, "The request has been fulfilled, resulting in the creation of a new resource."),
    ACCEPTED (202, "The request has been accepted for processing, but the processing has not been completed. The request might or might not be eventually acted upon, and may be disallowed when processing occurs."),
    NON_AUTHORITATIVE_INFORMATION (203, "The server is a transforming proxy (e.g. a Web accelerator) that received a 200 OK from its origin, but is returning a modified version of the origin's response."),
    NO_CONTENT (204, "The server successfully processed the request, and is not returning any content."),
    RESET_CONTENT (205, "The server successfully processed the request, asks that the requester reset its document view, and is not returning any content."),
    PARTIAL_CONTENT (206, "The server is delivering only part of the resource (byte serving) due to a range header sent by the client. The range header is used by HTTP clients to enable resuming of interrupted downloads, or split a download into multiple simultaneous streams."),
    MULTI_STATUS (207, "The message body that follows is by default an XML message and can contain a number of separate response codes, depending on how many sub-requests were made."),
    ALREADY_REPORTED (208, "The members of a DAV binding have already been enumerated in a preceding part of the (multistatus) response, and are not being included again."),
    I_AM_USED (226, "The server has fulfilled a request for the resource, and the response is a representation of the result of one or more instance-manipulations applied to the current instance."),
    MULTIPLE_CHOICES (300, "Indicates multiple options for the resource from which the client may choose (via agent-driven content negotiation)."),
    MOVED_PERMANENTLY (301, "This and all future requests should be directed to the given URI. "),
    FOUND (302, "Tells the client to look at (browse to) another URL. The HTTP/1.0 specification required the client to perform a temporary redirect with the same method (the original describing phrase was \"Moved Temporarily\"), but popular browsers implemented 302 redirects by changing the method to GET. Therefore, HTTP/1.1 added status codes 303 and 307 to distinguish between the two behaviours."),
    SEE_OTHER (303, "The response to the request can be found under another URI using the GET method. When received in response to a POST (or PUT/DELETE), the client should presume that the server has received the data and should issue a new GET request to the given URI."),
    NOT_MODIFIED (304, "Indicates that the resource has not been modified since the version specified by the request headers If-Modified-Since or If-None-Match. In such case, there is no need to retransmit the resource since the client still has a previously-downloaded copy."),
    USE_PROXY (305, "The requested resource is available only through a proxy, the address for which is provided in the response. For security reasons, many HTTP clients (such as Mozilla Firefox and Internet Explorer) do not obey this status code."),
    SWITCH_PROXY (306, "No longer used. Originally meant \"Subsequent requests should use the specified proxy.\""),
    TEMPORARY_REDIRECT (307, "In this case, the request should be repeated with another URI; however, future requests should still use the original URI. In contrast to how 302 was historically implemented, the request method is not allowed to be changed when reissuing the original request."),
    PERMANENT_REDIRECT (308, "This and all future requests should be directed to the given URI. 308 parallel the behaviour of 301, but does not allow the HTTP method to change."),
    BAD_REQUEST (400, "The server cannot or will not process the request due to an apparent client error (e.g., malformed request syntax, size too large, invalid request message framing, or deceptive request routing)."),
    UNAUTHORIZED (401, "Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided. The response must include a WWW-Authenticate header field containing a challenge applicable to the requested resource. See Basic access authentication and Digest access authentication. 401 semantically means \"unauthorised\", the user does not have valid authentication credentials for the target resource. Note: Some sites incorrectly issue HTTP 401 when an IP address is banned from the website (usually the website domain) and that specific address is refused permission to access a website.[citation needed]"),
    PAYMENT_REQUIRED (402, "Reserved for future use. The original intention was that this code might be used as part of some form of digital cash or micropayment scheme, as proposed"),
    FORBIDDEN (403, "The request contained valid data and was understood by the server, but the server is refusing action. This may be due to the user not having the necessary permissions for a resource or needing an account of some sort, or attempting a prohibited action (e.g. creating a duplicate record where only one is allowed). This code is also typically used if the request provided authentication by answering the WWW-Authenticate header field challenge, but the server did not accept that authentication. The request should not be repeated."),
    NOT_FOUND (404, "The requested resource could not be found but may be available in the future. Subsequent requests by the client are permissible."),
    METHOD_NOT_ALLOWED (405, "A request method is not supported for the requested resource"),
    NOT_ACCEPTABLE (406, "The requested resource is capable of generating only content not acceptable according to the Accept headers sent in the request. See Content negotiation."),
    PROXY_AUTHENTICATION_REQUIRED (407, "The client must first authenticate itself with the proxy."),
    REQUEST_TIMEOUT (408, "The server timed out waiting for the request. According to HTTP specifications: \"The client did not produce a request within the time that the server was prepared to wait. The client MAY repeat the request without modifications at any later time.\""),
    CONFLICT (409, "Indicates that the request could not be processed because of conflict in the current state of the resource, such as an edit conflict between multiple simultaneous updates."),
    GONE (410, "Indicates that the resource requested is no longer available and will not be available again. This should be used when a resource has been intentionally removed and the resource should be purged. Upon receiving a 410 status code, the client should not request the resource in the future. Clients such as search engines should remove the resource from their indices. Most use cases do not require clients and search engines to purge the resource, and a \"404 Not Found\" may be used instead."),
    LENGTH_REQUIRED (411, "The request did not specify the length of its content, which is required by the requested resource."),
    PRECONDITION_FAILED (412, "The server does not meet one of the preconditions that the requester put on the request header fields."),
    PAYLOAD_TOO_LARGE (413, "The request is larger than the server is willing or able to process. Previously called \"Request Entity Too Large\"."),
    URI_TOO_LONG (414, "The URI provided was too long for the server to process. Often the result of too much data being encoded as a query-string of a GET request, in which case it should be converted to a POST request. Called \"Request-URI Too Long\" previously."),
    UNSUPPORTED_MEDIA_TYPE (415, "The request entity has a media type which the server or resource does not support."),
    RANGE_NOT_SATISFIABLE (416, "The client has asked for a portion of the file (byte serving), but the server cannot supply that portion."),
    EXPECTATION_FAILED (417, "The server cannot meet the requirements of the Expect request-header field."),
    I_AM_A_TEAPOT (418, "This code was defined in 1998 as one of the traditional IETF April Fools' jokes, in RFC 2324, Hyper Text Coffee Pot Control Protocol, and is not expected to be implemented by actual HTTP servers. The RFC specifies this code should be returned by teapots requested to brew coffee. This HTTP status is used as an Easter egg in some websites, such as Google.com's I'm a teapot easter egg."),
    MISDIRECTED_REQUEST (421, "The request was directed at a server that is not able to produce a response."),
    UNPROCESSABLE_ENTITY (422, "The request was well-formed but was unable to be followed due to semantic errors."),
    LOCKED (423, "The resource that is being accessed is locked."),
    FAILED_DEPENDENCY (424, "The request failed because it depended on another request and that request failed (e.g., a PROPPATCH)."),
    TOO_EARLY (425, "Indicates that the server is unwilling to risk processing a request that might be replayed."),
    UPGRADE_REQUIRED (426, "The client should switch to a different protocol such as TLS/1.3, given in the Upgrade header field."),
    PRECONDITION_REQUIRED (428, "The origin server requires the request to be conditional. Intended to prevent the 'lost update' problem, where a client GETs a resource's state, modifies it, and PUTs it back to the server, when meanwhile a third party has modified the state on the server, leading to a conflict."),
    TOO_MANY_REQUESTS (429, "The user has sent too many requests in a given amount of time. Intended for use with rate-limiting schemes."),
    REQUEST_HEADER_FIELDS_TOO_LARGE (431, "The server is unwilling to process the request because either an individual header field, or all the header fields collectively, are too large."),
    UNAVAILABLE_FOR_LEGAL_REASONS (451, "A server operator has received a legal demand to deny access to a resource or to a set of resources that includes the requested resource. The code 451 was chosen as a reference to the novel Fahrenheit 451 (see the Acknowledgements in the RFC)."),
    INTERNAL_SERVER_ERROR (500, "A generic error message, given when an unexpected condition was encountered and no more specific message is suitable."),
    NOT_IMPLEMENTED (501, "The server either does not recognize the request method, or it lacks the ability to fulfil the request. Usually this implies future availability (e.g., a new feature of a web-service API)."),
    BAD_GATEWAY (502, "The server was acting as a gateway or proxy and received an invalid response from the upstream server."),
    SERVICE_UNAVAILABLE (503, "The server cannot handle the request (because it is overloaded or down for maintenance). Generally, this is a temporary state."),
    GATEWAY_TIMEOUT (504, "The server was acting as a gateway or proxy and did not receive a timely response from the upstream server."),
    HTTP_VERSION_NOT_SUPPORTED (505, "The server does not support the HTTP protocol version used in the request."),
    VARIANT_ALSO_NEGOTIATES (506, "Transparent content negotiation for the request results in a circular reference."),
    INSUFFICIENT_STORAGE (507, "The server is unable to store the representation needed to complete the request."),
    LOOP_DETECTED (508, "The server detected an infinite loop while processing the request (sent instead of 208 Already Reported)."),
    NOT_EXTENDED (510, "Further extensions to the request are required for the server to fulfil it."),
    NETWORK_AUTHENTICATION_REQUIRED (511, "The client needs to authenticate to gain network access. Intended for use by intercepting proxies used to control access to the network (e.g., \"captive portals\" used to require agreement to Terms of Service before granting full Internet access via a Wi-Fi hotspot).");
    
    private Integer code;
    private String signification;

    private CodeHttp(Integer code, String signification)
    {
        this.code = code;
        this.signification = signification;
    }

    public String getName() {
        return name().replace("_", " ");
    }
    public Integer getCode() {
        return code;
    }
    public String getSignification() {
        return signification;
    }

    public static CodeHttp getCodeHttpByCode(Integer code)
    {
        for(CodeHttp codeHttp : CodeHttp.values()) {
            if (codeHttp.getCode().equals(code))
                return codeHttp;
        }
        return null;
    }
}
