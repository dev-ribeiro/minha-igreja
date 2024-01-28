import { Congregation } from "@models/Congregation";
import { CongregationService } from "@services/CongregationService";
import { useEffect, useState } from "react"
import { useForm } from "react-hook-form";

export function useCongration() {
  const congregationService = new CongregationService();

  const [
    registerCongregationModalVisibility,
    setRegisterCongregationModalVisibility
  ] = useState(false);

  const registerCongretionForm = useForm<Congregation>();

  const updateRegisterCongregationModalVisibility = (value: boolean) => {
    setRegisterCongregationModalVisibility(value);
  }

  const registerCongregation = async (data: Congregation) => {
    try {
      const result = await congregationService.register(data);
      console.log(result);
    } catch (error) {
      alert("Houve um erro")
    }
  }

  const findAll = async () => {
    try {
      const result = await congregationService.findAll();
      console.log(result);
    } catch (error) {
      alert("Houve um erro")
    }
  }

  useEffect(() => {
    findAll();
  }, [])

  return {
    registerCongregationModalVisibility,
    updateRegisterCongregationModalVisibility,
    registerCongretionForm,
    registerCongregation,
  }
}
