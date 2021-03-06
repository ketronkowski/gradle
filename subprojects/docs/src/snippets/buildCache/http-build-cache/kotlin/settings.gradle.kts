rootProject.name = "http-build-cache"
// tag::http-build-cache[]
buildCache {
    remote<HttpBuildCache> {
        url = uri("https://example.com:8123/cache/")
    }
}
// end::http-build-cache[]

// tag::allow-untrusted-server[]
buildCache {
    remote<HttpBuildCache> {
        url = uri("https://example.com:8123/cache/")
        isAllowUntrustedServer = true
    }
}
// end::allow-untrusted-server[]

// tag::follow-redirects[]
buildCache {
    remote<HttpBuildCache> {
        url = uri("https://example.com:8123/cache/")
        isFollowRedirects = true
    }
}
// end::follow-redirects[]
