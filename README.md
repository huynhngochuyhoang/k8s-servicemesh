# k8s-servicemesh

> **_NOTE:_**  In this repo, i'm running kubernetes environment on Docker Desktop, and I've created istio-ingressgateway listen on port 82. If you are using Minikube, then you have to change the allowOrigin from ```check-notificaition-istio-virtual-service.yaml``` to your Minikube IP, then change the apiUrl value to your istio-ingressgateway ```External-IP``` in ```environment.prod.ts```, then rebuild the client docker image and update ```client-deployment.yaml``` to using your client image.

## Start the demo
```
$ kubectl create namespace notification
$ kubectl apply -f k8s/
```
## Verify deployment by terminal
Hit multiple times command below to see the difference
```
$ curl <istio-ingress-gateway-address>/api/checkNotification/refresh
$ curl <istio-ingress-gateway-address>/api/checkNotification/showUnreadNotification
```
## Verify deployment by browser
Open the browser and enter ```localhost``` if you're using Docker Desktop on Windows. Otherwise, enter the MinikubeIP
## View the dashboard
```
$ kubectl apply -f addons/
$ istioctl dashboard kiali
```
