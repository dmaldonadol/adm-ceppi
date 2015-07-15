
    drop table ACCESO cascade constraints;

    drop table CATEGORIA_SOCIO cascade constraints;

    drop table CENTRO_COSTO cascade constraints;

    drop table GASTO cascade constraints;

    drop table INGRESO cascade constraints;

    drop table JUGADOR cascade constraints;

    drop table JUGADOR_SKILL_JUGADOR cascade constraints;

    drop table MENU cascade constraints;

    drop table PERFIL cascade constraints;

    drop table PERSONA cascade constraints;

    drop table PROFESION cascade constraints;

    drop table SKILL cascade constraints;

    drop table SKILL_JUGADOR cascade constraints;

    drop table SOCIO cascade constraints;

    drop table TIPO_GASTO cascade constraints;

    drop table TIPO_SOCIO cascade constraints;

    drop table USUARIO cascade constraints;

    drop sequence SEC_ACCESO;

    drop sequence SEC_CATEGORIA_SOCIO;

    drop sequence SEC_CENTRO_COSTO;

    drop sequence SEC_GASTO;

    drop sequence SEC_INGRESO;

    drop sequence SEC_JUGADOR;

    drop sequence SEC_MENU;

    drop sequence SEC_PERFIL;

    drop sequence SEC_PERSONA;

    drop sequence SEC_PROFESION;

    drop sequence SEC_SKILL;

    drop sequence SEC_SKILL_JUGADOR;

    drop sequence SEC_SOCIO;

    drop sequence SEC_TIPO_GASTO;

    drop sequence SEC_TIPO_SOCIO;

    drop sequence SEC_USUARIO;

    create table ACCESO (
        ID_ACCESO number(10,0) not null,
        permiso varchar2(255 char),
        ID_MENU number(10,0),
        ID_PERFIL number(10,0),
        primary key (ID_ACCESO)
    );

    create table CATEGORIA_SOCIO (
        ID_CATEGORIA_SOCIO number(10,0) not null,
        codigo varchar2(255 char),
        descripcion varchar2(255 char),
        nombre varchar2(255 char),
        primary key (ID_CATEGORIA_SOCIO)
    );

    create table CENTRO_COSTO (
        ID_CENTRO_COSTO number(10,0) not null,
        codigo varchar2(255 char),
        descripcion varchar2(255 char),
        nombre varchar2(255 char),
        primary key (ID_CENTRO_COSTO)
    );

    create table GASTO (
        ID_GASTO number(10,0) not null,
        detalle varchar2(255 char),
        fecha varchar2(255 char),
        monto varchar2(255 char),
        ID_CENTRO_COSTO number(10,0),
        ID_TIPO_GASTO number(10,0),
        primary key (ID_GASTO)
    );

    create table INGRESO (
        ID_INGRESO number(10,0) not null,
        fecha varchar2(255 char),
        ID_SOCIO number(10,0),
        primary key (ID_INGRESO)
    );

    create table JUGADOR (
        ID_JUGADOR number(10,0) not null,
        numero varchar2(255 char),
        posicion varchar2(255 char),
        ID_PERSONA number(10,0),
        primary key (ID_JUGADOR)
    );

    create table JUGADOR_SKILL_JUGADOR (
        JUGADOR_ID_JUGADOR number(10,0) not null,
        skillJugador_ID_SKILL_JUGADOR number(10,0) not null,
        unique (skillJugador_ID_SKILL_JUGADOR)
    );

    create table MENU (
        TIPO varchar2(31 char) not null,
        ID_MENU number(10,0) not null,
        codigo varchar2(255 char),
        nombre varchar2(255 char),
        orden varchar2(255 char),
        path varchar2(255 char),
        permiso varchar2(255 char),
        ID_PADRE number(10,0),
        primary key (ID_MENU)
    );

    create table PERFIL (
        ID_PERFIL number(10,0) not null,
        codigo varchar2(255 char),
        descripcion varchar2(255 char),
        primary key (ID_PERFIL)
    );

    create table PERSONA (
        ID_PERSONA number(10,0) not null,
        apellidoMaterno varchar2(100 char),
        apellidoPaterno varchar2(100 char) not null,
        dv varchar2(1 char),
        email varchar2(50 char),
        estatura varchar2(255 char),
        genero varchar2(255 char),
        nombre varchar2(100 char) not null,
        peso varchar2(255 char),
        rut varchar2(10 char) unique,
        ID_TIPO_SOCIO number(10,0),
        primary key (ID_PERSONA)
    );

    create table PROFESION (
        ID_PROFESION number(10,0) not null,
        codigo varchar2(255 char),
        descripcion varchar2(255 char),
        nombre varchar2(255 char),
        primary key (ID_PROFESION)
    );

    create table SKILL (
        ID_SKILL number(10,0) not null,
        descripcion varchar2(255 char),
        nombre varchar2(255 char),
        tipo number(10,0),
        primary key (ID_SKILL)
    );

    create table SKILL_JUGADOR (
        ID_SKILL_JUGADOR number(10,0) not null,
        data varchar2(255 char),
        primary key (ID_SKILL_JUGADOR)
    );

    create table SOCIO (
        ID_SOCIO number(10,0) not null,
        estado number(10,0),
        ID_CATEGORIA_SOCIO number(10,0),
        ID_PERSONA number(10,0),
        ID_TIPO_SOCIO number(10,0),
        primary key (ID_SOCIO)
    );

    create table TIPO_GASTO (
        ID_TIPO_GASTO number(10,0) not null,
        codigo varchar2(255 char),
        descripcion varchar2(255 char),
        nombre varchar2(255 char),
        primary key (ID_TIPO_GASTO)
    );

    create table TIPO_SOCIO (
        ID_TIPO_SOCIO number(10,0) not null,
        codigo varchar2(255 char),
        descripcion varchar2(255 char),
        nombre varchar2(255 char),
        primary key (ID_TIPO_SOCIO)
    );

    create table USUARIO (
        ID_USUARIO number(10,0) not null,
        password varchar2(20 char) not null,
        username varchar2(20 char) not null,
        ID_PERSONA number(10,0),
        primary key (ID_USUARIO)
    );

    alter table ACCESO 
        add constraint FK72BAA960D74BE1B 
        foreign key (ID_PERFIL) 
        references PERFIL;

    alter table ACCESO 
        add constraint FK72BAA960E165B58E 
        foreign key (ID_MENU) 
        references MENU;

    alter table GASTO 
        add constraint FK40752F4D932612 
        foreign key (ID_CENTRO_COSTO) 
        references CENTRO_COSTO;

    alter table GASTO 
        add constraint FK40752F499051916 
        foreign key (ID_TIPO_GASTO) 
        references TIPO_GASTO;

    alter table INGRESO 
        add constraint FK9ECFBE914AD0DCF2 
        foreign key (ID_SOCIO) 
        references SOCIO;

    alter table JUGADOR 
        add constraint FKDFA027A281EF84EF 
        foreign key (ID_PERSONA) 
        references PERSONA;

    alter table JUGADOR_SKILL_JUGADOR 
        add constraint FK2402D5B77931DB71 
        foreign key (JUGADOR_ID_JUGADOR) 
        references JUGADOR;

    alter table JUGADOR_SKILL_JUGADOR 
        add constraint FK2402D5B7ECA1601B 
        foreign key (skillJugador_ID_SKILL_JUGADOR) 
        references SKILL_JUGADOR;

    alter table MENU 
        add constraint FK240D5FB9768E86 
        foreign key (ID_PADRE) 
        references MENU;

    alter table MENU 
        add constraint FK240D5F6CA3D16D 
        foreign key (ID_PADRE) 
        references MENU;

    alter table PERSONA 
        add constraint FK25B5B8C9A638CC8 
        foreign key (ID_TIPO_SOCIO) 
        references TIPO_SOCIO;

    alter table SKILL 
        add constraint FK4B4D23193D2F06A 
        foreign key (ID_SKILL) 
        references SKILL_JUGADOR;

    alter table SOCIO 
        add constraint FK4B68CCD9A638CC8 
        foreign key (ID_TIPO_SOCIO) 
        references TIPO_SOCIO;

    alter table SOCIO 
        add constraint FK4B68CCD46CAFBEE 
        foreign key (ID_CATEGORIA_SOCIO) 
        references CATEGORIA_SOCIO;

    alter table SOCIO 
        add constraint FK4B68CCD81EF84EF 
        foreign key (ID_PERSONA) 
        references PERSONA;

    alter table USUARIO 
        add constraint FK22E07F0E81EF84EF 
        foreign key (ID_PERSONA) 
        references PERSONA;

    create sequence SEC_ACCESO;

    create sequence SEC_CATEGORIA_SOCIO;

    create sequence SEC_CENTRO_COSTO;

    create sequence SEC_GASTO;

    create sequence SEC_INGRESO;

    create sequence SEC_JUGADOR;

    create sequence SEC_MENU;

    create sequence SEC_PERFIL;

    create sequence SEC_PERSONA;

    create sequence SEC_PROFESION;

    create sequence SEC_SKILL;

    create sequence SEC_SKILL_JUGADOR;

    create sequence SEC_SOCIO;

    create sequence SEC_TIPO_GASTO;

    create sequence SEC_TIPO_SOCIO;

    create sequence SEC_USUARIO;
