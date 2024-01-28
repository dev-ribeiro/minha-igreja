import { api } from "@libs/api";
import { Congregation } from "@models/Congregation";
import { CongregationDTO } from "@to/CongregationDTO";
import { ResponseDTO } from "@to/ResponseDTO";
import { AxiosResponse } from "axios";

export class CongregationService {

  constructor(private http = api) { }

  async register(to: CongregationDTO) {
    type Response = AxiosResponse<ResponseDTO<Congregation>>;

    const response: Response = await this.http.post("/congregation", to);

    return response.data;
  }

  async findAll() {
    type Response = AxiosResponse<ResponseDTO<Congregation[]>>;

    const response: Response = await this.http.get("/congregation");

    return response.data;
  }

}
