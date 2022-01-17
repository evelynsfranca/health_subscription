export interface ApiResponse<T> {
  status?: number;
  entity?: T;
}