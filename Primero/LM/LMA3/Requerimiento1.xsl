<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html lang="es">
            <head>
                <meta charset="UTF-8"/>
                <title>ITE</title>
                <link rel="stylesheet" href="css/style.css"/>
            </head>
            <body>
                <h1><xsl:value-of select="//ite/@nombre"/></h1>
                <section id="reparto">
                    <h2>Reparto</h2>
                    <table id="tablaRol">
                        <tr>
                            <th>Rol</th>
                            <th>Nombre</th>
                        </tr>
                        <tr>
                            <td>Directora</td>
                            <td>
                                <details>
                                    <summary><xsl:value-of select="//director/nombre" /></summary>
                                    <p>Despacho: <xsl:value-of select="//director/despacho" /></p>
                                </details>
                            </td>
                        </tr>
                        <tr>
                            <td>Jefe de estudios</td>
                            <td>
                                <details>
                                    <summary><xsl:value-of select="//jefe_estudios/nombre" /></summary>
                                    <p>Despacho: <xsl:value-of select="//jefe_estudios/despacho" /></p>
                                </details>
                            </td>
                        </tr>
                    </table>
                    <section id="profesores">
                        <h3>Profesores</h3>
                        <ul>
                            <xsl:for-each select="//profesores/profesor">
                                <li><xsl:value-of select="nombre"/></li>
                            </xsl:for-each>                        
                        </ul>
                    </section>
                </section>
                <section id="ciclos">
                    <h2>Ciclos</h2>
                    <table>
                        <tr>
                            <th colspan="2">Nombre</th>
                            <th>Grado</th>
                            <th>Decreto Título</th>
                        </tr>
                        <xsl:for-each select="//ciclos/ciclo">
                            <tr>
                                <xsl:choose>
                                    <xsl:when test="@id='ASIR'">
                                        <th><a href="asir.html"><xsl:value-of select="@id"/></a></th>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <th><a href="https://institutotecnologico.edix.com/home"><xsl:value-of select="@id"/></a></th>
                                    </xsl:otherwise>
                                </xsl:choose>
                                <td><xsl:value-of select="nombre"/></td>
                                <td><xsl:value-of select="grado"/></td>
                                <td><xsl:value-of select="decretoTitulo/@anio"/></td>
                            </tr>
                        </xsl:for-each>
                    </table>
                </section>
                <section id="formulario">
                    <h2>Contáctanos</h2>
                    <form action="recibido.html" method="post">
                        <fieldset class="columna" id="contacto">
                            <legend>Datos de contacto</legend>
                            <label for="nombre">Nombre</label>
                            <input type="text" name="nombre" id="nombre" autofocus="true" required="true"/>
                            <label for="tlf">Teléfono</label>
                            <input type="tel" name="tlf" id="tlf" placeholder="+34-xxx-xxx-xxx" required="true"/>
                            <label for="email">Email</label>
                            <input type="email" name="email" id="email" required="true"/>
                        </fieldset>
                        <fieldset class="columna" id="mensaje">
                            <legend>Mensaje</legend>
                            <label for="mensaje">mensaje</label>
                            <textarea name="mensaje" id="mensaje" rows="5" 
                            required="true" minlength="10" placeholder="escribe tu mensaje"/>
                        </fieldset>
                        <section id="botones">
                            <input type="reset" id="reset" value="Restablecer" />
                            <input type="submit" id="submit" value="Enviar" />
                        </section>
                    </form>
                    <section class="columna" id="empresa">
                        <h3>Información de contacto</h3>
                        <xsl:value-of select="//empresa" /> <br/>
                        <xsl:value-of select="//telefono" />
                    </section>
                </section>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>