Feature: Ingresar al login de MyStore
  @loginStore
  Scenario: Validacion del precio del Producto
    Given estoy en la pagina de la tienda
    And me logueo con mi usuario "admin@gmail.com" y clave "zxcvbnmasdfghq"
    When navego a la categoria Clothes y subcategoria Men
    And agrego 2 unidades del primer producto del carrito
    Then valido en el popup la confirmacion del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    When finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito