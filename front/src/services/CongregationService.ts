import { api } from "@libs/api";
import { CongregationDTO } from "@to/CongregationDTO";

export class CongregationService {

  constructor(private http = api) { }

  async register(to: CongregationDTO) {
    const response = await this.http.post("/congregation", to);

    return response.data;
  }

  async findAll() {
    const response = await this.http.get("/congregation");

    return response.data;
  }

}
