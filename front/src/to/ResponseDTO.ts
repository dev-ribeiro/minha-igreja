export class ResponseDTO<T> {
  success: boolean;
  numberOfElements?: number;
  response: T;
}
