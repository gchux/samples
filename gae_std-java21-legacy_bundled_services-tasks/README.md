Forked from: 

https://github.com/GoogleCloudPlatform/java-docs-samples/tree/main/appengine-java11/helloworld-servlet

---

## Install Google Cloud SDK

https://cloud.google.com/sdk/docs/install

## Deploy GAE Standard Service

```sh
./mvnw clean package appengine:deploy
gcloud app deploy src/main/appengine/dispatch.yaml
```

## Deploy GAE Task Queue 

```sh
gcloud app deploy src/main/appengine/queue.yaml
```

## Add tasks to the Queue

```sh
curl -ivL -XGET http://<gae-service>-dot-<gcp-project>.appspot.com/task/push
```
