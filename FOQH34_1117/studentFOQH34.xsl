<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <!-- ${workspace_loc:/FOQH34_1117/studentFOQH34.xml}  -->
	<xsl:template match="/">
	<html>
		<body>
			<h2>Toth Gergo</h2>
			<table style="border: 3px solid black;">
				<tr style="border:1px solid black; background: lime">
					<strong>
					<td style="border:1px solid black;">ID</td>
					<td style="border:1px solid black;">Vezeteknev</td>
					<td style="border:1px solid black;">Keresztnev</td>
					<td style="border:1px solid black;">Becenev</td>
					<td style="border:1px solid black;">Kor</td>
					</strong>
					<xsl:for-each select="/class/student">
					<tr style="border:1px solid black">
						<td style="border:1px solid black;"><xsl:value-of select="id"></xsl:value-of></td>
						<td style="border:1px solid black;"><xsl:value-of select="vezeteknev"></xsl:value-of></td>
						<td style="border:1px solid black;"><xsl:value-of select="keresztnev"></xsl:value-of></td>
						<td style="border:1px solid black;"><xsl:value-of select="becenev"></xsl:value-of></td>
						<td style="border:1px solid black;"><xsl:value-of select="kor"></xsl:value-of></td>
					</tr>
					</xsl:for-each>
				</tr>
				<tr>
					
				</tr>
			</table>
		</body>
	</html>	
		<!-- TODO: Auto-generated template -->
	</xsl:template>
</xsl:stylesheet>