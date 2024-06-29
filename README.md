# sgd_backend

Microservicio Java para backend

# pasos para usar docker

1. Instalar docker en su máquina, luego validar: `docker -v`
2. posicionar en la raiz del proyecto
3. crear una archivo en la raiz `.env` con las variables que salen en: `.env.template`
4. ejecutar comando `docker compose build`, generará las imagenes del proyecto
5. ejecutar comando `docker compose up` para levantar contendores

6. si todo sale bien ejecutar en el navegador: `http://localhost:807/api/v1/demo-controller/pruebaAppFreeToken`

# abrir phpmyadmin

- validar BD

1. abrir `http://localhost:8081/` y colocar credenciales `servidor: bd-sgd-back`, `usuario: root`, `contraseña: 123456`
