Forked from: 

https://github.com/GoogleCloudPlatform/java-docs-samples/tree/main/appengine-java8/helloworld

---

## Install Google Cloud SDK

https://cloud.google.com/sdk/docs/install

## Deploy GAE Standard Service

```sh
./mvnw clean package appengine:deploy
gcloud app deploy src/main/appengine/dispatch.yaml
```

> see [routing rules](src/main/appengine/dispatch.yaml)

## Deploy GAE Task Queue 

```sh
gcloud app deploy src/main/appengine/queue.yaml
```

> see [queue config](src/main/appengine/queue.yaml)

## Add tasks to the Queue

```sh
curl -ivL -XGET https://<gae-service>-dot-<gcp-project>.appspot.com/task-j8/push
```

> see [handler implementation](src/main/java/com/example/appengine/PushTask.java)

