CREATE TABLE area (
	codArea NUMBER ( 10 ) NOT NULL,
	nomArea VARCHAR2 ( 255 ) NOT NULL,
	area_ID NUMBER ( 10 ) NOT NULL,
	centroCosto_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_area15 PRIMARY KEY (area_ID)
	);

	CREATE INDEX TC_area70 ON area (centroCosto_ID );

CREATE TABLE centroCosto (
	codCC NUMBER ( 10 ) NOT NULL,
	nomCC VARCHAR2 ( 255 ) NOT NULL,
	centroCosto_ID NUMBER ( 10 ) NOT NULL,
	viatico_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_centroCosto6 PRIMARY KEY (centroCosto_ID),
	CONSTRAINT TC_centroCosto35 UNIQUE (viatico_ID)
	);
	


CREATE TABLE solicitudViaticos (
	codSolicitud NUMBER ( 10 ) NOT NULL,
	fecRegistro DATE NOT NULL,
	fecInicio DATE NOT NULL,
	fecFin DATE NOT NULL,
	horas NUMBER ( 1 ) NOT NULL,
	pernocta NUMBER ( 1 ) NOT NULL,
	duracion NUMBER ( 10 ) NOT NULL,
	motivoComision VARCHAR2 ( 255 ) NOT NULL,
	motivoRechazo VARCHAR2 ( 255 ) NOT NULL,
	solicitudViaticos_ID NUMBER ( 10 ) NOT NULL,
	centroCosto_ID NUMBER ( 10 ) NOT NULL,
	empleado_ID NUMBER ( 10 ) NOT NULL,
	empleado_empleado_ID NUMBER ( 10 ) NOT NULL,
	COL_1 NUMBER ( 10 ) NOT NULL,
	destino_ID NUMBER ( 10 ) NOT NULL,
	tipoComision_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_solicitudViaticos8 PRIMARY KEY (solicitudViaticos_ID)
	);
	
CREATE INDEX TC_solicitudViaticos57 ON solicitudViaticos (centroCosto_ID );
CREATE INDEX TC_solicitudViaticos54 ON solicitudViaticos (empleado_empleado_ID );
CREATE INDEX TC_solicitudViaticos53 ON solicitudViaticos (tipoComision_ID );
CREATE INDEX TC_solicitudViaticos56 ON solicitudViaticos (COL_1 );
CREATE INDEX TC_solicitudViaticos58 ON solicitudViaticos (empleado_ID );
CREATE INDEX TC_solicitudViaticos55 ON solicitudViaticos (destino_ID );

CREATE TABLE viatico (
	codViatico NUMBER ( 10 ) NOT NULL,
	destino VARCHAR2 ( 255 ) NOT NULL,
	fecAprobacion DATE NOT NULL,
	fecInicio DATE NOT NULL,
	fecFin DATE NOT NULL,
	motivoComision VARCHAR2 ( 255 ) NOT NULL,
	montoTotal FLOAT ( 64 ) NOT NULL,
	fecAutoriza DATE NOT NULL,
	viatico_ID NUMBER ( 10 ) NOT NULL,
	solicitudViaticos_ID NUMBER ( 10 ) NOT NULL,
	empleado_ID NUMBER ( 10 ) NOT NULL,
	presupuesto_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT TC_viatico22 UNIQUE (solicitudViaticos_ID),
	CONSTRAINT PK_viatico14 PRIMARY KEY (viatico_ID)
	);

CREATE INDEX TC_viatico68 ON viatico (empleado_ID );
CREATE INDEX TC_viatico69 ON viatico (presupuesto_ID );

CREATE TABLE rendicion (
	codRendicion NUMBER ( 10 ) NOT NULL,
	duracion NUMBER ( 10 ) NOT NULL,
	fecInicio DATE NOT NULL,
	fecFin DATE NOT NULL,
	montoTotal FLOAT ( 64 ) NOT NULL,
	montoDevolucion FLOAT ( 64 ) NOT NULL,
	rendicion_ID NUMBER ( 10 ) NOT NULL,
	tarjetaCorporativa_ID NUMBER ( 10 ) NOT NULL,
	viatico_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_rendicion7 PRIMARY KEY (rendicion_ID),
	CONSTRAINT TC_rendicion24 UNIQUE (tarjetaCorporativa_ID),
	CONSTRAINT TC_rendicion37 UNIQUE (viatico_ID)
	);

CREATE TABLE gasto (
	fecRegistroGasto DATE NOT NULL,
	tipoGasto VARCHAR2 ( 255 ) NOT NULL,
	rendicion_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_gasto4 PRIMARY KEY (rendicion_ID)
	);


CREATE TABLE tarjetaCorporativa (
	numTarjeta VARCHAR2 ( 255 ) NOT NULL,
	numCuenta VARCHAR2 ( 255 ) NOT NULL,
	fecRegistro DATE NOT NULL,
	fecActivacion DATE NOT NULL,
	credito FLOAT ( 64 ) NOT NULL,
	fecCancelacion DATE NOT NULL,
	tarjetaCorporativa_ID NUMBER ( 10 ) NOT NULL,
	viatico_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_tarjetaCorporativa9 PRIMARY KEY (tarjetaCorporativa_ID),
	CONSTRAINT TC_tarjetaCorporativa32 UNIQUE (viatico_ID)
	);

CREATE TABLE proveedor (
	ruc VARCHAR2 ( 255 ) NOT NULL,
	nomProveedor VARCHAR2 ( 255 ) NOT NULL,
	proveedor_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_proveedor18 PRIMARY KEY (proveedor_ID)
	);
	
CREATE TABLE presupuesto (
	codPresupuesto NUMBER ( 10 ) NOT NULL,
	anno VARCHAR2 ( 255 ) NOT NULL,
	presupuestoAsignado FLOAT ( 64 ) NOT NULL,
	presupuestoEjecutado FLOAT ( 64 ) NOT NULL,
	presupuesto_ID NUMBER ( 10 ) NOT NULL,
	centroCosto_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_presupuesto21 PRIMARY KEY (presupuesto_ID)
	);
CREATE INDEX TC_presupuesto71 ON presupuesto (centroCosto_ID );

CREATE TABLE categoria (
	codCategoria NUMBER ( 10 ) NOT NULL,
	nomCategoria VARCHAR2 ( 255 ) NOT NULL,
	categoria_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_categoria16 PRIMARY KEY (categoria_ID)
	);
	
CREATE TABLE empleado (
	codEmleado NUMBER ( 10 ) NOT NULL,
	nombre VARCHAR2 ( 255 ) NOT NULL,
	apellido VARCHAR2 ( 255 ) NOT NULL,
	tipoDocumento VARCHAR2 ( 255 ) NOT NULL,
	numeroDocuento VARCHAR2 ( 255 ) NOT NULL,
	fecNacimiento DATE NOT NULL,
	correo VARCHAR2 ( 255 ) NOT NULL,
	empleado_ID NUMBER ( 10 ) NOT NULL,
	area_ID NUMBER ( 10 ) NOT NULL,
	categoria_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_empleado10 PRIMARY KEY (empleado_ID)
	);
CREATE INDEX TC_empleado61 ON empleado (area_ID );
CREATE INDEX TC_empleado60 ON empleado (categoria_ID );

CREATE TABLE tipoComprobante (
	tipoComprobante VARCHAR2 ( 255 ) NOT NULL,
	descripcion VARCHAR2 ( 255 ) NOT NULL,
	tipoComprobante_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_tipoComprobante20 PRIMARY KEY (tipoComprobante_ID)
	);
	
CREATE TABLE tipoComision (
	codComision NUMBER ( 10 ) NOT NULL,
	nomComision VARCHAR2 ( 255 ) NOT NULL,
	tipoComision_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_tipoComision23 PRIMARY KEY (tipoComision_ID)
	);
	
CREATE TABLE destino (
	codDestino NUMBER ( 10 ) NOT NULL,
	nomDestino VARCHAR2 ( 255 ) NOT NULL,
	zonaCritica NUMBER ( 1 ) NOT NULL,
	destino_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_destino17 PRIMARY KEY (destino_ID)
	);
	
CREATE TABLE conceptoGasto (
	codConcepto NUMBER ( 10 ) NOT NULL,
	nomConcepto VARCHAR2 ( 255 ) NOT NULL,
	conceptoGasto_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_conceptoGasto11 PRIMARY KEY (conceptoGasto_ID)
	);
	
CREATE TABLE conceptoAsignado (
	montoGasto FLOAT ( 64 ) NOT NULL,
	conceptoGasto_ID NUMBER ( 10 ) NOT NULL,
	viatico_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_conceptoAsignado5 PRIMARY KEY (viatico_ID)
	);
CREATE INDEX TC_conceptoAsignado49 ON conceptoAsignado (conceptoGasto_ID );


CREATE TABLE gastoEfectivo (
	fecGasto DATE NOT NULL,
	montoGasto FLOAT ( 64 ) NOT NULL,
	observacion VARCHAR2 ( 255 ) NOT NULL,
	rendicion_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_gastoEfectivo25 PRIMARY KEY (rendicion_ID)
	);


CREATE TABLE gastoTarjeta (
	fecOperacion DATE NOT NULL,
	nroComprobante VARCHAR2 ( 255 ) NOT NULL,
	montoComprobante FLOAT ( 64 ) NOT NULL,
	conceptoGasto_ID NUMBER ( 10 ) NOT NULL,
	proveedor_ID NUMBER ( 10 ) NOT NULL,
	tipoComprobante_ID NUMBER ( 10 ) NOT NULL,
	rendicion_ID NUMBER ( 10 ) NOT NULL,
	CONSTRAINT PK_gastoTarjeta24 PRIMARY KEY (rendicion_ID)
	);

CREATE INDEX TC_gastoTarjeta63 ON gastoTarjeta (tipoComprobante_ID );
CREATE INDEX TC_gastoTarjeta64 ON gastoTarjeta (conceptoGasto_ID );
CREATE INDEX TC_gastoTarjeta65 ON gastoTarjeta (proveedor_ID );

ALTER TABLE viatico ADD ( CONSTRAINT FK_viatico11 FOREIGN KEY (solicitudViaticos_ID) REFERENCES solicitudViaticos (solicitudViaticos_ID));
ALTER TABLE viatico ADD ( CONSTRAINT FK_viatico16 FOREIGN KEY (empleado_ID) REFERENCES empleado (empleado_ID));
ALTER TABLE viatico ADD ( CONSTRAINT FK_viatico28 FOREIGN KEY (presupuesto_ID) REFERENCES presupuesto (presupuesto_ID));
ALTER TABLE gastoEfectivo ADD ( CONSTRAINT FK_gastoEfectivo31 FOREIGN KEY (rendicion_ID) REFERENCES gasto (rendicion_ID));
ALTER TABLE solicitudViaticos ADD ( CONSTRAINT FK_solicitudViaticos29 FOREIGN KEY (tipoComision_ID) REFERENCES tipoComision (tipoComision_ID));
ALTER TABLE solicitudViaticos ADD ( CONSTRAINT FK_solicitudViaticos14 FOREIGN KEY (empleado_empleado_ID) REFERENCES empleado (empleado_ID));
ALTER TABLE solicitudViaticos ADD ( CONSTRAINT FK_solicitudViaticos25 FOREIGN KEY (destino_ID) REFERENCES destino (destino_ID));
ALTER TABLE solicitudViaticos ADD ( CONSTRAINT FK_solicitudViaticos15 FOREIGN KEY (COL_1) REFERENCES empleado (empleado_ID));
ALTER TABLE solicitudViaticos ADD ( CONSTRAINT FK_solicitudViaticos7 FOREIGN KEY (centroCosto_ID) REFERENCES centroCosto (centroCosto_ID));
ALTER TABLE solicitudViaticos ADD ( CONSTRAINT FK_solicitudViaticos13 FOREIGN KEY (empleado_ID) REFERENCES empleado (empleado_ID));
ALTER TABLE empleado ADD ( CONSTRAINT FK_empleado24 FOREIGN KEY (categoria_ID) REFERENCES categoria (categoria_ID));
ALTER TABLE empleado ADD ( CONSTRAINT FK_empleado23 FOREIGN KEY (area_ID) REFERENCES area (area_ID));
ALTER TABLE centroCosto ADD ( CONSTRAINT FK_centroCosto21 FOREIGN KEY (viatico_ID) REFERENCES viatico (viatico_ID));
ALTER TABLE presupuesto ADD ( CONSTRAINT FK_presupuesto9 FOREIGN KEY (centroCosto_ID) REFERENCES centroCosto (centroCosto_ID));
ALTER TABLE conceptoAsignado ADD ( CONSTRAINT FK_conceptoAsignado20 FOREIGN KEY (viatico_ID) REFERENCES viatico (viatico_ID));
ALTER TABLE conceptoAsignado ADD ( CONSTRAINT FK_conceptoAsignado17 FOREIGN KEY (conceptoGasto_ID) REFERENCES conceptoGasto (conceptoGasto_ID));
ALTER TABLE gasto ADD ( CONSTRAINT FK_gasto10 FOREIGN KEY (rendicion_ID) REFERENCES rendicion (rendicion_ID));
ALTER TABLE area ADD ( CONSTRAINT FK_area8 FOREIGN KEY (centroCosto_ID) REFERENCES centroCosto (centroCosto_ID));
ALTER TABLE tarjetaCorporativa ADD ( CONSTRAINT FK_tarjetaCorporativa19 FOREIGN KEY (viatico_ID) REFERENCES viatico (viatico_ID));
ALTER TABLE gastoTarjeta ADD ( CONSTRAINT FK_gastoTarjeta30 FOREIGN KEY (rendicion_ID) REFERENCES gasto (rendicion_ID));
ALTER TABLE gastoTarjeta ADD ( CONSTRAINT FK_gastoTarjeta27 FOREIGN KEY (tipoComprobante_ID) REFERENCES tipoComprobante (tipoComprobante_ID));
ALTER TABLE gastoTarjeta ADD ( CONSTRAINT FK_gastoTarjeta18 FOREIGN KEY (conceptoGasto_ID) REFERENCES conceptoGasto (conceptoGasto_ID));
ALTER TABLE gastoTarjeta ADD ( CONSTRAINT FK_gastoTarjeta26 FOREIGN KEY (proveedor_ID) REFERENCES proveedor (proveedor_ID));
ALTER TABLE rendicion ADD ( CONSTRAINT FK_rendicion12 FOREIGN KEY (tarjetaCorporativa_ID) REFERENCES tarjetaCorporativa (tarjetaCorporativa_ID));
ALTER TABLE rendicion ADD ( CONSTRAINT FK_rendicion22 FOREIGN KEY (viatico_ID) REFERENCES viatico (viatico_ID));

