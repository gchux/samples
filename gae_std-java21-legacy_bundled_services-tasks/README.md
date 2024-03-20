Forked from: 

https://github.com/GoogleCloudPlatform/java-docs-samples/tree/main/appengine-java11/helloworld-servlet

---

```sh
./mvnw clean package appengine:deploy
gcloud app deploy src/main/appengine/dispatch.yaml
gcloud app deploy src/main/appengine/queue.yaml
```
