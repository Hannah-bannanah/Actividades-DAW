<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml" indent="yes"/>
    <xsl:template match="/">
        <!--Cambio de etiqueta ciclos a grados, ciclo a grado-->
        <grados>
            <xsl:for-each select="//ciclos/ciclo">
                <grado>
                    <id><xsl:value-of select="@id"/></id>
                    <titulo><xsl:value-of select="nombre"/></titulo>
                    <anio><xsl:value-of select="decretoanio"/></anio>
                    <nombreCentro><xsl:value-of select="//empresa"/></nombreCentro>
                </grado>
            </xsl:for-each>
        </grados>

        <!--Creación de un grupo EMPLEADOS, que contiene profesores, director y jefe de estudios-->
        <xsl:element name="empleados">
            <director><xsl:copy-of select="//director"/></director>
            <jefe_estudios><xsl:copy-of select="//jefe_estudios"/></jefe_estudios>
            <profesores>
                <xsl:for-each select="//profesores/profesor">
                <!--Ordenación de los profesores según su id en orden descendente-->
                <xsl:sort select="id" order="descending"/>
                <!--Transformación del elemento "id" en atributo del elemento "profesor"-->
                    <profesor>
                        <xsl:attribute name="id">
                            <xsl:value-of select="id"/>
                        </xsl:attribute>
                        <nombre><xsl:value-of select="nombre"/></nombre>
                    </profesor>
                </xsl:for-each>
            </profesores>
        </xsl:element>
    </xsl:template>
</xsl:stylesheet>