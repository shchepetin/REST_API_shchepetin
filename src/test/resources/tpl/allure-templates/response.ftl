<#assign response = data.response>
=== RESPONSE ===
Status Code: ${response.statusCode}

Headers:
<#list response.headers![] as header>
    ${header.name}: ${header.value}
</#list>

Body:
${response.body}