PGDMP                  	        |            orm_gestion_instituto    15.2    15.2 )    G           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            H           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            I           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            J           1262    17984    orm_gestion_instituto    DATABASE     �   CREATE DATABASE orm_gestion_instituto WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = icu LOCALE = 'en_US.UTF-8' ICU_LOCALE = 'en-US';
 %   DROP DATABASE orm_gestion_instituto;
                postgres    false            �            1259    18458    alumnos    TABLE     �   CREATE TABLE public.alumnos (
    id integer NOT NULL,
    segundo_apellido character varying(50),
    primer_apellido character varying(50),
    nia character varying(9),
    nombre character varying(30),
    telefono character varying(9)
);
    DROP TABLE public.alumnos;
       public         heap    postgres    false            �            1259    18457    alumnos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.alumnos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.alumnos_id_seq;
       public          postgres    false    215            K           0    0    alumnos_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.alumnos_id_seq OWNED BY public.alumnos.id;
          public          postgres    false    214            �            1259    18465    direcciones    TABLE     �   CREATE TABLE public.direcciones (
    id integer NOT NULL,
    calle character varying(100),
    numero integer,
    poblacion character varying(50),
    provincia character varying(30)
);
    DROP TABLE public.direcciones;
       public         heap    postgres    false            �            1259    18464    direcciones_id_seq    SEQUENCE     �   CREATE SEQUENCE public.direcciones_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.direcciones_id_seq;
       public          postgres    false    217            L           0    0    direcciones_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.direcciones_id_seq OWNED BY public.direcciones.id;
          public          postgres    false    216            �            1259    18472    modulos    TABLE     �   CREATE TABLE public.modulos (
    id integer NOT NULL,
    curso character varying(30),
    horas integer NOT NULL,
    nombre character varying(30),
    id_profesor integer
);
    DROP TABLE public.modulos;
       public         heap    postgres    false            �            1259    18478    modulos_alumnos    TABLE     j   CREATE TABLE public.modulos_alumnos (
    modulos_id integer NOT NULL,
    alumnos_id integer NOT NULL
);
 #   DROP TABLE public.modulos_alumnos;
       public         heap    postgres    false            �            1259    18471    modulos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.modulos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.modulos_id_seq;
       public          postgres    false    219            M           0    0    modulos_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.modulos_id_seq OWNED BY public.modulos.id;
          public          postgres    false    218            �            1259    18482 
   profesores    TABLE       CREATE TABLE public.profesores (
    id_profesor integer NOT NULL,
    segundo_apellido character varying(50),
    primer_apellido character varying(50),
    nombre character varying(30),
    telefono character varying(9),
    profesor_direccion integer
);
    DROP TABLE public.profesores;
       public         heap    postgres    false            �            1259    18481    profesores_id_profesor_seq    SEQUENCE     �   CREATE SEQUENCE public.profesores_id_profesor_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.profesores_id_profesor_seq;
       public          postgres    false    222            N           0    0    profesores_id_profesor_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.profesores_id_profesor_seq OWNED BY public.profesores.id_profesor;
          public          postgres    false    221            �           2604    18461 
   alumnos id    DEFAULT     h   ALTER TABLE ONLY public.alumnos ALTER COLUMN id SET DEFAULT nextval('public.alumnos_id_seq'::regclass);
 9   ALTER TABLE public.alumnos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �           2604    18468    direcciones id    DEFAULT     p   ALTER TABLE ONLY public.direcciones ALTER COLUMN id SET DEFAULT nextval('public.direcciones_id_seq'::regclass);
 =   ALTER TABLE public.direcciones ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    217    217            �           2604    18475 
   modulos id    DEFAULT     h   ALTER TABLE ONLY public.modulos ALTER COLUMN id SET DEFAULT nextval('public.modulos_id_seq'::regclass);
 9   ALTER TABLE public.modulos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    219    219            �           2604    18485    profesores id_profesor    DEFAULT     �   ALTER TABLE ONLY public.profesores ALTER COLUMN id_profesor SET DEFAULT nextval('public.profesores_id_profesor_seq'::regclass);
 E   ALTER TABLE public.profesores ALTER COLUMN id_profesor DROP DEFAULT;
       public          postgres    false    222    221    222            =          0    18458    alumnos 
   TABLE DATA           _   COPY public.alumnos (id, segundo_apellido, primer_apellido, nia, nombre, telefono) FROM stdin;
    public          postgres    false    215   �/       ?          0    18465    direcciones 
   TABLE DATA           N   COPY public.direcciones (id, calle, numero, poblacion, provincia) FROM stdin;
    public          postgres    false    217   &0       A          0    18472    modulos 
   TABLE DATA           H   COPY public.modulos (id, curso, horas, nombre, id_profesor) FROM stdin;
    public          postgres    false    219   C0       B          0    18478    modulos_alumnos 
   TABLE DATA           A   COPY public.modulos_alumnos (modulos_id, alumnos_id) FROM stdin;
    public          postgres    false    220   `0       D          0    18482 
   profesores 
   TABLE DATA           z   COPY public.profesores (id_profesor, segundo_apellido, primer_apellido, nombre, telefono, profesor_direccion) FROM stdin;
    public          postgres    false    222   }0       O           0    0    alumnos_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.alumnos_id_seq', 1, true);
          public          postgres    false    214            P           0    0    direcciones_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.direcciones_id_seq', 1, false);
          public          postgres    false    216            Q           0    0    modulos_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.modulos_id_seq', 1, false);
          public          postgres    false    218            R           0    0    profesores_id_profesor_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.profesores_id_profesor_seq', 1, false);
          public          postgres    false    221            �           2606    18463    alumnos alumnos_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.alumnos DROP CONSTRAINT alumnos_pkey;
       public            postgres    false    215            �           2606    18470    direcciones direcciones_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.direcciones
    ADD CONSTRAINT direcciones_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.direcciones DROP CONSTRAINT direcciones_pkey;
       public            postgres    false    217            �           2606    18477    modulos modulos_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.modulos
    ADD CONSTRAINT modulos_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.modulos DROP CONSTRAINT modulos_pkey;
       public            postgres    false    219            �           2606    18487    profesores profesores_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT profesores_pkey PRIMARY KEY (id_profesor);
 D   ALTER TABLE ONLY public.profesores DROP CONSTRAINT profesores_pkey;
       public            postgres    false    222            �           2606    18489 (   direcciones uk_3ok9hd8e3vhq8gwvmueh4ovtj 
   CONSTRAINT     e   ALTER TABLE ONLY public.direcciones
    ADD CONSTRAINT uk_3ok9hd8e3vhq8gwvmueh4ovtj UNIQUE (numero);
 R   ALTER TABLE ONLY public.direcciones DROP CONSTRAINT uk_3ok9hd8e3vhq8gwvmueh4ovtj;
       public            postgres    false    217            �           2606    18491 '   profesores uk_ay8hetgu5t1led5wyrir08xjg 
   CONSTRAINT     f   ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT uk_ay8hetgu5t1led5wyrir08xjg UNIQUE (telefono);
 Q   ALTER TABLE ONLY public.profesores DROP CONSTRAINT uk_ay8hetgu5t1led5wyrir08xjg;
       public            postgres    false    222            �           2606    18493 '   profesores uk_e5wj4sd0tktqo1ivi38qyxkde 
   CONSTRAINT     p   ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT uk_e5wj4sd0tktqo1ivi38qyxkde UNIQUE (profesor_direccion);
 Q   ALTER TABLE ONLY public.profesores DROP CONSTRAINT uk_e5wj4sd0tktqo1ivi38qyxkde;
       public            postgres    false    222            �           2606    18494 #   modulos fkbc3wugw8bavn4g91wk5dee9mh    FK CONSTRAINT     �   ALTER TABLE ONLY public.modulos
    ADD CONSTRAINT fkbc3wugw8bavn4g91wk5dee9mh FOREIGN KEY (id_profesor) REFERENCES public.profesores(id_profesor);
 M   ALTER TABLE ONLY public.modulos DROP CONSTRAINT fkbc3wugw8bavn4g91wk5dee9mh;
       public          postgres    false    219    222    3493            �           2606    18504 +   modulos_alumnos fke655jj5qktan6yqsr3bxpdgb1    FK CONSTRAINT     �   ALTER TABLE ONLY public.modulos_alumnos
    ADD CONSTRAINT fke655jj5qktan6yqsr3bxpdgb1 FOREIGN KEY (modulos_id) REFERENCES public.modulos(id);
 U   ALTER TABLE ONLY public.modulos_alumnos DROP CONSTRAINT fke655jj5qktan6yqsr3bxpdgb1;
       public          postgres    false    220    3491    219            �           2606    18499 +   modulos_alumnos fkfr7738gayfhg6p22r1x0jtmev    FK CONSTRAINT     �   ALTER TABLE ONLY public.modulos_alumnos
    ADD CONSTRAINT fkfr7738gayfhg6p22r1x0jtmev FOREIGN KEY (alumnos_id) REFERENCES public.alumnos(id);
 U   ALTER TABLE ONLY public.modulos_alumnos DROP CONSTRAINT fkfr7738gayfhg6p22r1x0jtmev;
       public          postgres    false    3485    215    220            �           2606    18509 &   profesores fkk3yp46sotb8nubl8mwtft6uj2    FK CONSTRAINT     �   ALTER TABLE ONLY public.profesores
    ADD CONSTRAINT fkk3yp46sotb8nubl8mwtft6uj2 FOREIGN KEY (profesor_direccion) REFERENCES public.direcciones(id);
 P   ALTER TABLE ONLY public.profesores DROP CONSTRAINT fkk3yp46sotb8nubl8mwtft6uj2;
       public          postgres    false    3487    222    217            =   $   x�3�LKL�,�L��442�L�K�4�0����� g�P      ?      x������ � �      A      x������ � �      B      x������ � �      D      x������ � �     