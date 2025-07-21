<#assign request = data.request>
=== REQUEST ===
Method: ${request.method}
URL: ${request.uri}

Headers:
<@list data.request.headers! [] as header>
  ${header.name}: ${header.value}
</@list>

Body:
${request.body}