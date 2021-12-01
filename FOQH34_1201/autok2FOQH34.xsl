<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template --><html>
			<body>
			<h2>rendszamok</h2>
				<p>
					<xsl:value-of select="count(/autok/auto[@ar &gt; 30000])"></xsl:value-of>
					
					</p>
			ííííí</body>		
		</html>
	</xsl:template>
</xsl:stylesheet>