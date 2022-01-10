# k8s-servicemesh

> **_NOTE:_**  In this repo, i'm running kubernetes environment on Docker Desktop, and I've created istio-ingressgateway listen on port 82. If you are using Minikube, then you have to change the allowOrigin from ```check-notificaition-istio-virtual-service.yaml``` to your Minikube IP, then change the apiUrl value to your external-ip in ```environment.prod.ts``` and rebuild the client docker image.

## Start the demo
```
$ kubectl create namespace notification
$ kubectl apply -f k8s/
```
## Verify deploy
Hit multiple times command below to see the difference
```
$ curl <istio-ingress-gateway-address>/api/checkNotification/refresh
```
