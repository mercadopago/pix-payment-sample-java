# Procesamiento de pago con Pix a través de Checkout API
[English](README.md) / [Português](README.pt.md)

**:warning: Atención: Pix es un método de pago solo disponible en Brasil**

## :computer: Tecnologías
- Java 11
- [Spring Boot](https://spring.io/projects/spring-boot) 2.5.5
- [Maven](https://maven.apache.org/) (dependency manager)

## 💡 Requisitos
- Java 8 o superior (sigue las instrucciones de descarga [aquí](https://java.com/es/download/help/download_options.html)).
- [Lee nuestras instrucciones](https://www.mercadopago.com.br/developers/es/guides/overview#bookmark_el_desarrollo_con_c%C3%B3digo) sobre cómo crear una aplicación en el Panel de Desarrolladores de Mercado Pago para obtener el access token. Esta llave te dará acceso a las API de Mercado Pago.
- Para obtener información detallada sobre cómo recibir pagos con Pix, [por favor lee nuestra guía](https://www.mercadopago.com.br/developers/es/guides/online-payments/checkout-api/other-payment-ways#bookmark_recibir_pagos_con_pix) en Mercado Pago Developers.

## :gear: Instalación
1. Clona el proyecto.
```bash
git clone https://github.com/mercadopago/pix-payment-sample-java.git
```

2. Accede a la carpeta del proyecto.
```bash
cd pix-payment-sample-java
```

3. Ejecuta el siguiente comando:

Linux / MacOS
```bash
./mvnw clean install
```

Windows
```bash
./mvnw.cmd clean install
```

## 🌟 Como ejecutar
1. Ejecuta el siguiente comando para iniciar la aplicación:

Linux / MacOS
```bash
./mvnw spring-boot:run -Dspring-boot.run.arguments="--mercado_pago_sample_access_token=YOUR_ACCESS_TOKEN"
``` 

Windows
```bash
./mvnw.cmd spring-boot:run -Dspring-boot.run.arguments="--mercado_pago_sample_access_token=YOUR_ACCESS_TOKEN"
``` 

2. Recuerda cambiar el valor de `YOUR_ACCESS_TOKEN` por la [credencial](https://www.mercadopago.com.br/developers/panel) de su cuenta.

3. Accede a http://localhost:8080 en su navegador.

### :test_tube: Pruebas
- En nuestras [instrucciones de prueba](https://www.mercadopago.com.br/developers/es/guides/online-payments/checkout-api/testing) encontrarás una guía sobre cómo crear **[usuarios de prueba](https://www.mercadopago.com.br/developers/es/guides/online-payments/checkout-api/testing#bookmark_c_mo_crear_usuarios)**.
- Tienes que [crear una clave Pix](https://www.mercadopago.com.br/stop/pix) en la cuenta del Vendedor en Mercado Pago (recuerda que puedes crear y usar un usuario de prueba como Vendedor).
- **IMPORTANTE:** existen algunas limitaciones al realizar pruebas de este medio de pago con test users. Al crear un pago, este quedará pendiente y se devolverán el código Pix y Código QR correspondientes, pero no será posible utilizar dichos códigos para finalizar el flujo y aprobar el pago de prueba.

## :handshake: Contribuyendo
Puedes contribuir a este proyecto informando problemas y bugs. Antes de abrir una contribución, lee nuestro [código de conducta](CODE_OF_CONDUCT.md).

## :bookmark: Licencia
MIT License. Copyright (c) 2021 - Mercado Pago <br/>
Para obtener más información, consulte el archivo [LICENSE](LICENSE).
