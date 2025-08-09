package main.java.pageObjects;
//Dentro de esta clase se almacenaran todos los localizadores que se ocuparan.
public interface CC_Localizadores_Enfermo_Terminal2 {

	//Login
	String inputUsuario = "//*[@id=\"normal_login_username\"]"; //XPATH  nombre de usuario ubicado en csv posicion 0
	String inputContrasena = "//*[@id=\"normal_login_password\"]"; //XPATH password ubicado en csv posicion 1
	String btnIngresar =  "//button[normalize-space()='Ingresar']"; ; //XPATH boton ingresar
	
	//Valida login exitoso a SAGCOM
	String validaLoginExitoso = "//h1[contains(text(), 'Sistema de Apoyo a la Gestión de las Comisiones Médicas')]";
	
	//Ingresar datos para nueva solicitud (datos desde csv)
	String inputRutSolicitante = "//input[@id='rut']"; //XPATH  rut solicitante ubicacion en csv 2
	String btnComenzar = "//button[normalize-space()='Comenzar']"; 
	
	//Valida ingreso a creacion de nueva solicitud mediante la busqueda por rut de un solicitante
	String validaCrearNuevaSolicitud = "//h3[contains(text(), 'Ingreso de Nueva Solicitud')]"; //

    //Ingresar informacion del solicitante paso 1
	String clickOptTipoSolicitud  = "//input[@id='tipoExpediente']/ancestor::div[contains(@class,'ant-select')]/div[@class='ant-select-selector']"; //Click para opcion tipo de solicitud
	String optTipoSolicitud  = "//div[contains(@class, 'ant-select-item-option') and text()='Calificación de invalidez de un afiliado']";//Opcion tipo de solicitud
	String nroInstitucion  = "//input[@id=\'numeroInterno\']"; //Ubicacion en csv 3
	String btnBuscar = "//button[normalize-space()='Buscar']"; //Click btn buscar para validar si existe alguna solicitud creada
	String optEnfermoTerminal = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si']])[1]"; //Seleciona opcion si/no enfermo terminal
	String buttonArchivo = "//button[span[text()='Adjuntar certificado']]";
	String subirfile = "certificadoEnfermoTerminal"; // Botonera para subir archivo
	String fechaRecepcionAfp  = "//input[contains(@placeholder, 'Seleccionar fecha')]"; //Ubicacion en csv 4, se llama igual a fecha de nacimiento
	String nombreSolicitante  = "//input[@id='nombre']"; //Ubicacion en csv 5
	String primerApellidoSolicitante  = "//input[@id='apellidoPaterno']"; //Ubicacion en csv 6
	String segundoApellidoSolicitante  = "//input[@id='apellidoMaterno']"; //Ubicacion en csv 7
	String fechaNacimiento  = "//*[@id=\"fechaNacimiento\"]"; //Ubicacion en csv 8
	String clickOptTipoSexo = "//input[@id='sexo']/ancestor::div[contains(@class, 'ant-select')]//div[contains(@class, 'ant-select-selector')]"; //Click para abrir la selecion tipo sexo
	String optTipoSexo = "//div[contains(@class, 'ant-select-item-option') and text()='Masculino']"; //Seleciona la opcion tiopo de sexo masculino
	String clickOptEstadoCivil = "//input[@id='estadoCivil']/ancestor::div[contains(@class,'ant-select')]/div[contains(@class,'ant-select-selector')]"; //Click para desplegar opciones de estado civil
	String optEstadoCivil = "//div[contains(@class, 'ant-select-item-option') and text()='Casado(a)']"; //Se pone en bruto por el momento, casado
	String profesion  = "//input[@id=\"profesionActividad\"]"; //Ubicacion en csv 9
	String optEmail = "//div[@id='isNoTieneEmail']//label[.//span[text()='No']]"; //Seleciona opsion si/no email en este caso sera opcion no
	String numeroMovil = "//input[@id='celular']"; //Ubicacion en csv 10
	String numeroFijo = "//input[@id='telefono']"; //Ubicacion en csv 11
	String clickOptNivelEducacional = "//input[@id='nivelEducacional']/ancestor::div[contains(@class, 'ant-select')]"; //Click para desplegar las opciones de nivel educacional
	String optNivelEducacional = "//div[contains(@class, 'ant-select-item-option') and text()='Analfabeto']"; //De momento selecciona analfabeto
	String clickOptRegion  = "//input[@id='region']/ancestor::div[contains(@class,'ant-select-selector')]"; //Click para desplegar las opociones de regiones
	String optRegion  = "//div[contains(@class, 'ant-select-item-option') and text()=concat('Libertador General Bernardo O', \"'\", 'Higgins')]"; //Seleciona opcion bernardo ohiggins
	String clickOptProvincia  = "//input[@id='ciudad']/ancestor::div[contains(@class, 'ant-select-selector')]"; //Click ára desplegar las opciones de provincia
	String optProvincia  = "//div[contains(@class, 'ant-select-item-option') and text()='Cachapoal']"; //Click opcion provincia cachapoal
	String clickOptComuna  = "//input[@id='comuna']/ancestor::div[contains(@class, 'ant-select')]/div[@class='ant-select-selector']"; //Click para desplegar las opciones de comuna
	String optComuna  = "//div[contains(@class, 'ant-select-item') and .//div[text()='Rancagua']]"; //Click opcion rancagua
	String direccion = "//input[@id='calle']"; //Ubicacion en csv 12
	String nroDireccion = "//input[@id='numero']"; //Ubicacion en csv 13
    String btnContinuar = "//button[contains(@class, 'ant-btn') and contains(@class, 'btn-form') and span[text()='Continuar']]"; //Click al btn continuar para seguir ingrdsando informacion del solicitante
	  
    //Ingresar informacion del solicitante paso 2
    String clickSituacionLaboral = "//div[contains(@class, 'ant-select') and contains(@class, 'ant-select-single') and .//input[@id='tipoTrabajador']]"; //Click para desplegar opciopn situacion laboral
    String optSituacionLaboral = "//div[contains(@class, 'ant-select-item-option') and text()='Desempleado por un periodo menor a 12 meses']"; //Click para seleccionar opcion Trabajador Independiente o voluntario
	String clickInstitucionSalud = "//input[@id='institucionSalud']/ancestor::div[contains(@class, 'ant-select-selector')]"; //Click para desplegar opciones tipo de salud ej: fonasa
	String optInstitucionSalud = "//div[contains(@class, 'ant-select-item-option') and text()='Colmena']"; //Click para seleccionar fonasa
	String fechaAfiliacionAfp = "//*[@id='fechaAfiliacionAfp']"; // Ubicacion en csv 14
	String opcCambioAfp = "//div[@id='cambioAfiliacion']//label[.//span[text()='No']]"; //Opcion si/no para si realizo cambio de afp (No)
	String opcMutualidad = "//div[@id='mutualidad']//label[.//span[text()='Si']]"; //¿Se encuentra pensionado por la ley 16.744? y ¿registra cotizaciones por ella? (No)
	String coberturaSis = "//div[@id='isCoberturaSis']//label[.//span[text()='Si']]"; //¿Cuenta con cobertura del SIS el solicitante? (No)
	String doccobersis= "//button[span[text()='Adjuntar documento de cobertura']]"; // Documento de cobertura del solicitante
	String conLicencia = "//div[@id='isLicenciaMedica']//label[.//span[text()='No']]"; //¿Está actualmente acogido a una licencia médica el solicitante? (No)
	String btnContinuarPaso2 ="//button[normalize-space()='Continuar']"; //Click botn continuar paso 2
	
	//Ingresar informacion del solicitante paso 3
    //Fecha de recepción de CAPRI no aplica
	String verifiincapacidadcermedi = "//div[@id='quienVerificaIncapacidad']//label[.//span[text()='Certificado médico']]"; //¿Beneficiario o afiliado incapacitado para comparecer en CM?
	String doccertimedico ="//button[span[text()='Adjuntar certificado']]"; // Subir documento
	String nombrePerVerificaIdentidadAfiliado = "//input[@id='nombreVerificaIdentidad']"; // Ubicacion en csv 15
	String requiereTercero = "//div[@id='isTercero']//label[.//span[text()='No']]"; //¿Requiere representación de un tercero? (No)
	String sufreaccidenteoenfermedad = "//div[@id='isAccidenteTrabajo']//label[.//span[text()='No']]"; // Ha sufrido algún accidente del trabajo o enfermedad profesional (No)
	String nombreafeccionoenfermedad ="//input[@id='enfermedadSolicitante']"; // Ubicacion en csv 16
	String opcionporcentaje = "//div[@id='porcentCargoAfiliado']//label[.//span[text()='20%']]"; //Entidad administradora del seguro de accidentes del trabajo y enfermedades profesionales que se encuentre adscrito el solicitante
	String btnContinuarPaso3 ="//button[normalize-space()='Continuar']"; //Click botn continuar paso 3

	//Adjuntar Antecedentes Médicos y otros paso 4
	String otrosantecedente = "//div[@id='isAcompanaAntecedentesMedicos']//label[.//span[text()='Si']]"; //Incorporar otros antecedentes si/no (Si)
	String clicknomnbredocumento = "//input[@id='tipoArchivos-1']/ancestor::div[contains(@class, 'ant-select-selector')]"; //Click para desplegar opciones Nombre Documento
	String optnombredocumento = "//div[contains(@class, 'ant-select-item-option') and text()='Evaluaciones Médicas']"; //Click para seleccionar Evaluaciones Médicas
	String doccertimedico2 ="documento-1"; // Subir documento
	String btnContinuarPaso4 ="//button[normalize-space()='Continuar']"; //Click botn continuar paso 4
	
	//Confirmación paso 5
	String btnfinalizar ="//button[normalize-space()='Finalizar']"; //Click botn Finalizar Solicitud
	
	// Aceprtar nueva solicitud
	String aceptarsolcitud ="//button[normalize-space()='Aceptar']"; // Presionar botonera Aceptar
	String clickperfil = "//input[@id='tipoArchivos-1']/ancestor::div[contains(@class, 'ant-select-selector')]"; //Click para desplegar opciones Nombre Documento
	String optcerrarsesion = "//div[contains(@class, 'ant-select-item-option') and text()='Evaluaciones Médicas']"; //Click para seleccionar Evaluaciones Médicas

	//Login Administrador
	String inputUsuarioadm = "//*[@id=\"normal_login_username\"]"; //XPATH  nombre de usuario ubicado en csv posicion 17
	String inputContrasenaamd = "//*[@id=\"normal_login_password\"]"; //XPATH password ubicado en csv posicion 18aceptarsolcitud
	String btnIngresaramd =  "//button[normalize-space()='Ingresar']"; //XPATH boton ingresar
	String validaLoginExitosoFlujoAdm = "//span[text()='Perfil Administrativo']"; //Valida login flujo administrativo
	String opcMiTrabajoAdministrativo = "//li[contains(@class, 'ant-menu-item') and .//span[text()='Mi Trabajo Administrativo']]"; //Valida login flujo administrativo
	String analisisAdmisibilidad = "//div[@class='ant-collapse-header']//span[contains(text(), 'Análisis de admisibilidad')]"; //Click opcion Análisis de admisibilidad
	String clickopcrutbuscar = "//input[@placeholder='Buscar rut' and contains(@class,'ant-input')]"; //Opcion Expedientes por tipo de prioridad
	String rutSolicitanteBuscar = "//input[@placeholder='Buscar rut' and contains(@class,'ant-input')]"; //Rut solicitante a buscar csv posicion 18 
	String opcionLupaBuscar = "//button[contains(@class, 'ant-input-search-button') and @type='button']"; //Click 
	String opcionVerMas = "//button[contains(@class, 'ant-btn-link') and span[text()='Ver más']]"; //Click ver mas
	String admisibilidadSolicitud = "//div[@id='isCompletitud']//label[.//span[text()='Aceptar']]"; //Click Admisibilidad de la solicitud aceptar
	String btnConfirmar = "//button[@type='submit' and span[text()='Confirmar']]"; //Click boton confirmar
	String clicksiprobar1 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[1]"; // click en Si, Apobar 1er documento
	String clicksiprobar2 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[3]"; // click en Si, Apobar 2do documento
	String clicksiprobar3 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[5]"; // click en Si, Apobar 3er documento
	String clicksiprobar4 = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='Si, Aprobar']])[7]"; // click en Si, Apobar 3er documento
	String clickAprobardoc = "//label[contains(@class, 'ant-radio-wrapper') and .//span[text()='Aceptar']]"; // click en Aprobar los documentos
	
	String btnContinuarexpedientecaso ="//button[normalize-space()='Confirmar']"; //Confirmar Expediente del Caso
	
	//Login Médico Presidente
	String validaLoginExitosoFlujoMedico = "//span[text()='Perfil Médico Presidente']"; //Valida login perfil flujo medico
	String inputUsuariomedicopresi = "//*[@id=\"normal_login_username\"]"; //XPATH  nombre de usuario Médico Presidente ubicado en csv posicion 19
	String inputContrasenamedicopresi = "//*[@id=\"normal_login_password\"]"; //XPATH password Médico Presidente ubicado en csv posicion 20 
	String btnIngresarmedpresi =  "//button[normalize-space()='Ingresar']"; //XPATH boton ingresar
	String opcMiTrabajomedicopresidente = "//li[contains(@class, 'ant-menu-item') and .//span[text()='Mi Trabajo']]"; //Valida login flujo administrativo
	String opcExpedientes = "//span[@class='ant-collapse-header-text' and text()='Expedientes']"; //Click opcion Expedientes
	String clickopcrutbuscarmedpresi = "//input[@placeholder='Buscar rut' and contains(@class,'ant-input')]"; //Opcion Expedientes por tipo de prioridad
	String rutSolicitanteBuscarmedipre = "//input[@placeholder='Buscar rut' and contains(@class,'ant-input')]"; //Rut solicitante a buscar csv posicion 2 
	String opcionLupaBuscarmedpresi = "//button[contains(@class, 'ant-input-search-button') and @type='button']"; //Click 
	String opcionVerMasmedpresi = "//button[contains(@class, 'ant-btn-link') and span[text()='Ver más']]"; //Click ver mas
	String opcevaluacionmedica = "//div[contains(@class, 'ant-tabs-tab-btn') and text()='Evaluación médica']"; //Click en Evaluación médica
	
	String Inputantecedentesper = "//*[@id='antecedentesPersonales']"; // Comentario en Antecedentes personales y/o laborales y/o mórbidos
	String cursalicenciamedica = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='No']])[2]"; // ¿Cursa con licencia médica? - No
	String inputAnamnesisycronolo = "//*[@id='anamnesisCronologia']"; // Comentario en Anamnesis y cronología de la evolución
	String inputtratamientoactual = "//*[@id='tratamientoActual']"; // Comentario en Tratamiento actual o reciente
	String inputotrostratamientos = "//*[@id='otrosTratamientos']"; // Comentario en Otros tratamientos
	String inputcomentarioEscenciales = "//*[@id='comentarioEscenciales']"; // Comentario en Seleccione las Actividades Esenciales interferidas
	String inputcomentariosdomesticos = "//*[@id='comentarioDomesticas']"; // Comentario en Seleccione las Actividades Domésticas interferidas
	String inputcomentarioDesplazamiento = "//*[@id='comentarioDesplazamiento']"; // Comentario en Seleccione las Actividades de Desplazamiento interferidas
	String inputcomentariosociales = "//*[@id='comentarioSociales']"; // Comentario en Seleccione las Actividades de Eficiencia Social interferidas
	String sospechainvalidez = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='No']])[4]"; // Sospecha de invalidez previa - No
	String btnguardarevamedica = "//button[@type='submit' and span[text()='Siguiente']]"; // Guarda Evuañuacion Médica
	String inputpulsaciones = "//*[@id='pulso']"; // Informar  Pulso
	String inputpresion = "//*[@id='presion']"; // Informar  Presion
	String inputalla = "//*[@id='talla']"; // Informar  Talla
	String inputpeso = "//*[@id='peso']"; // Informar  Peso

	String btnguardaexamenfisico = "(//button[@type='submit' and @class='ant-btn ant-btn-primary ant-btn-block btn-form' and span[text()='Siguiente']])[2]"; // Guarda Examen Físico
	String clickOptplanaccion = "//input[@id='planAccion']/ancestor::div[contains(@class, 'ant-select')]"; //Click para desplegar las opciones de nivel educacional
	String optclicckplanaccion = "//div[contains(@class, 'ant-select-item-option') and text()='Cierre de caso']"; //De momento selecciona Cierre de caso
	String inputcomentariofinal = "//*[@id='comentarioFinal']"; // Comentario en Argumentos, configuración, menoscabos y comentario final
	String btnconfiguraragregarimpedimento = "//button[@class='ant-btn ant-btn-primary ant-btn-block btn-form']//span[contains(text(), 'Configurar')]"; // Configurar y Agregar Impedimentos
	String btnagregarotroimpedimento = "(//span[@aria-label='plus-circle' and contains(@class, 'anticon-plus-circle')])[2]"; // Boton agregar Otro Impedimento
	String inputagregarimpedimento = "(//input[@placeholder='Agregue impedimentos' and contains(@class,'react-tags__search-input')])[2]"; // comentario en Plan de Acción - Configurar y Agregar Impedimentos
	String clickOptconfiguracion = "(//button[@role='switch' and @aria-checked='false'])[1]"; // Configuración la opción NO - Así habilita los campos Clase y rango
	String clickOptmenuclase = "(//input[@id='claseImpedimento']/ancestor::div[contains(@class, 'ant-select')])[1]"; //Click para desplegar las opciones de Nivel educacional
	String optclickmenuclase = "//div[contains(@class, 'ant-select-item-option') and text()='IV']"; // Seleccionar valor "IV"
	String clickOptmenurango = "(//input[@id='rangoImpedimento']/ancestor::div[contains(@class, 'ant-select')])[1]"; //Click para desplegar las opciones de Rango educacional
	String optclickmenurango = "//div[contains(@class, 'ant-select-item-option') and text()='Alto']"; // Seleccionar valor "Alto"
	String btnagregarimpedimento = "(//button[@type='submit' and @class='ant-btn ant-btn-primary ant-btn-block btn-form'])[4]"; // Botonera Agregar Otro Impedimento 	
	String opcconfiguracionAVD = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='No']])[6]"; // ¿Existen impedimentos configurados del mismo capítulo que afectan la misma área de AVD y se... - NO
	String opcasignarcie10 = "//button[@class='ant-btn ant-btn-link' and span[text()='Asignar cie10']]"; // Link Asignar cie10
	String inputcodigocie10 = "(//input[@class='ant-input' and @type='text'])[6]"; // Poner texto para filtrar COMPLICACIONES VENOSAS DEL EMBARAZO
	String optlupacie10 = "//button[contains(@class, 'ant-input-search-button') and @type='button']"; // Presionar lupa de búsqueda
	String clickencabeceranombre = "//thead[@class='ant-table-thead']//th[normalize-space()='Nombre']"; // Click en la cabecera de título Nombre
	String opccodigoasignarcie10 = "//td[.//label[contains(@class, 'ant-radio-wrapper')]]//input[@type='radio']"; //  Asignar código cie10 - O22	COMPLICACIONES VENOSAS DEL EMBARAZO	
	String btnagregarasignarcie10codigo = "//button[@type='button' and @class='ant-btn ant-btn-primary ant-btn-block' and span[text()='Asignar']]"; // Botonera Asignar cie10 
	String opcinvalidezprevia = "(//label[contains(@class, 'ant-radio-wrapper') and //span[text()='No']])[8]"; // Invalidez Previa - NO
	String btnguardarplandeaccion = "//button[@type='submit' and @class='ant-btn ant-btn-primary ant-btn-block btn-form' and span[text()='Guardar']]"; // Botonera Guardar Plan de Acción
	String btnenviarasesion = "//button[@type='button' and @class='ant-btn ant-btn-primary ant-btn-block' and span[text()='Enviar a sesión']]"; // Botonera Enviar a sesión
			
	// Login Administrativo - Creación de Tabla de Sesión (Enfermo Terminal)
	String inputUsuario2 = "//*[@id=\"normal_login_username\"]"; //XPATH  nombre de usuario ubicado en csv posicion 0
	String inputContrasena2 = "//*[@id=\"normal_login_password\"]"; //XPATH password ubicado en csv posicion 1
	String btnIngresaadm2 = "//button[normalize-space()='Ingresar']"; //  Botonera Ingresar Administrador
	String btntrespuntos = "(//div[contains(@class, 'ant-menu-submenu-title')])[2]"; // Seleccionar opción tres puntos
	String optsesiones = "(//span[@class='ant-menu-title-content' and text()='Sesiones'])[2]"; // Seleccionar opción sesiones para generar tablas
	String btncreartabla = "//button[span[text()='+ Crear tabla']]"; // Presionar botonera crear tabla
	String clickcalendariocreatabla = "//input[@placeholder='Seleccionar fecha']"; //Opcion Expedientes por tipo de prioridad
	String btncalendarioahora = "//a[contains(@class, 'ant-picker-now-btn') and contains(text(), 'Ahora')]"; // seleccionar la opcipón Ahora 
	String opcexpedientecalificacion = "//h5[@class='ant-typography' and contains(text(), 'Expedientes de calificación')]"; //Click opcion Expedientes
	String botoniconofiltro ="//button[span[text()='Filtros']]"; // click en ícono de filtro
	String rutfiltroadm = "//input[@id='rutSolicitante']"; // Ingresar rut a buscar
	String clickfiltrarut ="//span[@class='anticon anticon-search']"; // Presionar en ícono de busqieda
	String clickcheckbox = "(//input[@type='checkbox' and contains(@class,'ant-checkbox-input')])[2]"; // seleccionar checkbox
	String btncreatablasesion = "//button[span[text()='Crear tabla sesión']]"; // hacer click en Crear Tabla Sesion
	
}