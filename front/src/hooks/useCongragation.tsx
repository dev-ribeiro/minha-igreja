import { useState } from "react"

export function useCongration() {
  const [
    registerCongregationModalVisibility,
    setRegisterCongregationModalVisibility
  ] = useState(false);

  const updateRegisterCongregationModalVisibility = (value: boolean) => {
    setRegisterCongregationModalVisibility(value);
  }

  return {
    registerCongregationModalVisibility,
    updateRegisterCongregationModalVisibility
  }
}
