import { Congregation } from "@models/Congregation";
import { CongregationService } from "@services/CongregationService";
import { useMutation, useQuery } from "@tanstack/react-query";
import { useState } from "react"
import { useForm } from "react-hook-form";

export function useCongration() {
  const congregationService = new CongregationService();

  const { data: congregationsQuery } = useQuery({
    queryKey: ['congregations'],
    queryFn: async () => {
      return await congregationService.findAll();
    },
  });

  const congregationSaveMutation = useMutation({
    mutationKey: ['congregations'],
    mutationFn: async (to: Congregation) => {
      return await congregationService.register(to);
    }
  })

  const [
    registerCongregationModalVisibility,
    setRegisterCongregationModalVisibility
  ] = useState(false);

  const registerCongretionForm = useForm<Congregation>();

  const updateRegisterCongregationModalVisibility = (value: boolean) => {
    setRegisterCongregationModalVisibility(value);
  }

  const registerCongregation = (data: Congregation) => {
    congregationSaveMutation.mutate(data);
    updateRegisterCongregationModalVisibility(false);
  };

  return {
    congregationsQuery,
    registerCongregationModalVisibility,
    updateRegisterCongregationModalVisibility,
    registerCongretionForm,
    registerCongregation,
  }
}
