# sgd_backend

Microservicio Java para backend

# pasos para usar docker

1. Instalar docker en su máquina, luego validar: `docker -v`, (si no aparece nada en su consola, no puede continuar los pasos)
2. posicionar en la raiz del proyecto.
3. crear una archivo en la raiz `.env` con las variables que salen en: `.env.template`
4. ejecutar comando `docker compose build`, generará las imagenes del proyecto
5. ejecutar comando `docker compose up` para levantar contendores
   REZAR PARA QUE TODO RESULTE

6. si todo sale bien ejecutar en el navegador: `http://localhost:807/api/v1/demo-controller/pruebaAppFreeToken`, y debe ver mensaje de `Hola Nes Corp`

# abrir phpmyadmin

- validar BD

1. abrir `http://localhost:8081/` y colocar credenciales `servidor: bd-sgd-back`, `usuario: root`, `contraseña: 123456`

<!-- los pasos siguientes no se incluyen -->

docker compose -f docker-compose.prod.yml up --build

docker buildx build --platform linux/amd64 -t jean1991/sgd-back:1.0.0 -f Dockerfile.prod . --push

docker login registry.digitalocean.com
token digital: dop_v1_415f10993bf9b84ed2c06f2e5512b72aca45e874cc70f4a31c8c07b9c62c7115
docker buildx build --platform linux/amd64 -t registry.digitalocean.com/nes-corp-registry/sgd-back:1.0.0 -f Dockerfile.prod --push .
