<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<html>
			<body>
			<h2>rendszamok</h2>
			<xsl:for-each select="/autok/auto">
				<xsl:sort select="ar" />
					<p>
					<xsl:value-of select="@rsz"></xsl:value-of> :
					<xsl:value-of select="ar"></xsl:value-of>
					</p>
				
			</xsl:for-each>
			</body>		
		</html>
	</xsl:template>
</xsl:stylesheet>