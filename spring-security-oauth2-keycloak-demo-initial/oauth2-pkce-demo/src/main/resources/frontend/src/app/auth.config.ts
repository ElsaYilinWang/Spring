import {AuthConfig} from "angular-oauth2-oidc";

export const authConfig: AuthConfig = {
  issuer: 'http://localhost:8180/auth/realms/oauth2-demo-realm',
  redirectUri: window.location.origin,
  clientId: 'pkce',
  responseType: 'code',
  strictDiscoveryDocumentValidaition: false,
  scope: 'openid profile email offline_access',

}
