export const API_URL = "https://health-subscription-api.onrender.com/api"
export const API_KEY = process.env.NEXT_PUBLIC_API_KEY
export const API_USER = process.env.NEXT_PUBLIC_API_USER
export const API_TOKEN = "Basic " + Buffer.from(API_USER + ":" + API_KEY).toString('base64')