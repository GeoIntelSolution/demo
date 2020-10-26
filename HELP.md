# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.3.4.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-template-engines)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

https://github.com/mapbox/mapbox-gl-js/issues/7395
https://github.com/mapbox/mapbox-gl-js/pull/7039
https://bl.ocks.org/andrewharvey/7b61e9bdb4165e8832b7495c2a4f17f7
```
var tutocomponent = {
    template: `<div>
            <span>{{txt}}</span>
        </div>`,
    data: function() {
        return {
            txt: 'some text',
        };
    },
    // méthode appelée à l'initialisation du composant
    mounted() {
    },
    // méthodes générales du composant
    methods: {
    }
};

Vue.component("second-comp", second);

import tutocomp from "./js/tutocomponent.js";
    $('.create-tutocomponent').on('click', function() {
    var vuecomp = Vue.extend(tutocomp);
    var component = new vuecomp().$mount()
    $('#container').append(component.$el)
});

var component = new vuecomp({
    propsData: {
        values: valllll
    }
}).$mount()
```

