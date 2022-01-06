# k8s-servicemesh

## Start the demo
```
$ kubectl apply -f k8s/
```
## Verify deploy
Hit multiple times command below to see the difference
```
$ curl <istio-ingress-gateway-address>/api/checkNotification/refresh
```
